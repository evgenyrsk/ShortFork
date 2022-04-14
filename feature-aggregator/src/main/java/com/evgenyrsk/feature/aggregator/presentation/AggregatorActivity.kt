package com.evgenyrsk.feature.aggregator.presentation

import android.graphics.Rect
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.evgenyrsk.core.presentation.mvi.viewmodel.GenericSavedStateViewModelFactory
import com.evgenyrsk.feature.aggregator.R
import com.evgenyrsk.feature.aggregator.databinding.ActivityMainBinding
import com.evgenyrsk.feature.aggregator.databinding.SearchViewBinding
import com.evgenyrsk.feature.aggregator.di.AggregatorComponentHolder
import com.evgenyrsk.feature.aggregator.presentation.chart.ChartFragment
import com.evgenyrsk.feature.aggregator.presentation.description.CompanyDescriptionFragment
import com.evgenyrsk.feature.aggregator.presentation.indicators.IndicatorsFragment
import com.evgenyrsk.feature.aggregator.presentation.indicators.model.IndicatorsUiModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class AggregatorActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: AggregatorViewModelFactory

    private val viewModel: AggregatorViewModel by viewModels {
        GenericSavedStateViewModelFactory(viewModelFactory, this)
    }
    private val viewBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AggregatorComponentHolder.getComponent().inject(this)

        with(viewBinding) {
            setContentView(root)
            initSearchView(searchView)

            bottomNavigation.setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.navigation_description -> {
                        openScreen(CompanyDescriptionFragment.newInstance())
                        true
                    }
                    R.id.navigation_indicators -> {
                        openScreen(IndicatorsFragment.newInstance())
                        true
                    }
                    else -> false
                }
            }

            searchFab.setOnClickListener {
                hideCompanyName()
                showSearchView(withKeyboard = true)
            }
            companyName.isVisible = false
            viewModel.uiState.onEach { state ->
                if (state.indicatorsInfoState is IndicatorsInfoState.Loading) {
                    viewBinding.searchView.enterTickerNameField.hideKeyboardAndClearFocus()
                }
                if (state.indicatorsInfoState is IndicatorsInfoState.Loaded) {
                    hideSearchView(withKeyboard = false)
                    showCompanyName(state.indicatorsInfoState.model)
                }
            }.launchIn(lifecycleScope)
        }
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val v: View? = currentFocus
            if (v is EditText) {
                val outRect = Rect()
                v.getGlobalVisibleRect(outRect)
                if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                    hideSearchView(withKeyboard = true)
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }

    private fun initSearchView(searchView: SearchViewBinding) {
        searchView.enterTickerNameField.addTextChangedListener {
            searchView.clearIcon.isInvisible = it?.isEmpty() ?: false
        }
        searchView.enterTickerNameField.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val enteredTickerText = searchView.enterTickerNameField.text.toString()
                viewModel.setEvent(AggregatorEvent.OnSubmitTickerButtonClicked(enteredTickerText))
                viewBinding.searchView.enterTickerNameField.hideKeyboardAndClearFocus()
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
        searchView.clearIcon.setOnClickListener {
            searchView.enterTickerNameField.text.clear()
        }
    }

    private fun hideSearchView(withKeyboard: Boolean = false) = with(viewBinding.searchView) {
        root.animate()
            .alpha(0.0f)
            .withEndAction {
                root.isInvisible = true
                viewBinding.companyName.isVisible = true
                if (withKeyboard) {
                    enterTickerNameField.hideKeyboardAndClearFocus()
                }
                setFabEnabled(isEnabled = true)
            }
            .start()
    }

    private fun showSearchView(withKeyboard: Boolean = false) = with(viewBinding.searchView) {
        root.alpha = 0.0f
        root.animate()
            .alpha(1.0f)
            .withStartAction {
                viewBinding.companyName.isVisible = false
                root.isVisible = true
                setFabEnabled(isEnabled = false)
            }
            .withEndAction {
                if (withKeyboard) {
                    enterTickerNameField.showKeyboardAndRequestFocus()
                }
            }
            .start()
    }

    private fun showCompanyName(model: IndicatorsUiModel) {
        with(viewBinding.companyName) {
            alpha = 0.0f
            animate()
                .withStartAction {
                    isVisible = true
                    text = model.companyInfo.name
                }
                .alpha(1.0f)
                .start()
        }
    }

    private fun hideCompanyName() {
        with(viewBinding.companyName) {
            animate()
                .alpha(0.0f)
                .withEndAction { isVisible = false }
                .start()
        }
    }

    private fun setFabEnabled(isEnabled: Boolean) {
        viewBinding.searchFab.isEnabled = isEnabled
    }

    private fun openScreen(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.fragment_container, fragment)
        }
    }

    private fun EditText.hideKeyboardAndClearFocus() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
        clearFocus()
    }

    private fun EditText.showKeyboardAndRequestFocus() {
        requestFocus()
        (getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager).showSoftInput(this, 0)
    }

    class ViewPagerFragmentAdapter(host: FragmentActivity) : FragmentStateAdapter(host) {

        override fun getItemCount(): Int = PAGES_COUNT

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> IndicatorsFragment()
                else -> ChartFragment()
            }
        }

        private companion object {
            const val PAGES_COUNT = 2
        }
    }
}
