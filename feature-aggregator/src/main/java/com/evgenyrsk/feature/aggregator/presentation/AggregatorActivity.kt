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
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.evgenyrsk.core.presentation.mvi.viewmodel.GenericSavedStateViewModelFactory
import com.evgenyrsk.feature.aggregator.R
import com.evgenyrsk.feature.aggregator.databinding.ActivityMainBinding
import com.evgenyrsk.feature.aggregator.databinding.SearchViewBinding
import com.evgenyrsk.feature.aggregator.di.AggregatorComponentHolder
import com.evgenyrsk.feature.aggregator.presentation.chart.ChartFragment
import com.evgenyrsk.feature.aggregator.presentation.indicators.IndicatorsFragment
import com.google.android.material.internal.TextWatcherAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class AggregatorActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: AggregatorViewModelFactory

    private val viewModel: AggregatorViewModel by viewModels {
        GenericSavedStateViewModelFactory(viewModelFactory, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AggregatorComponentHolder.getComponent().inject(this)

        with(ActivityMainBinding.inflate(layoutInflater)) {
            setContentView(root)
            initSearchView(searchView)
            initViewPagerWithTabs(viewPager, tabs)

            companyInfoBlock.isVisible = false
            viewModel.uiState.onEach { state ->
                if (state.indicatorsInfoState is IndicatorsInfoState.Loaded) {
                    companyInfoBlock.alpha = 0.0f
                    companyInfoBlock.isVisible = true
                    companyInfoBlock.animate().alpha(1.0f)
                    val resultModel = state.indicatorsInfoState.model
                    companyName.text = resultModel.companyInfo.name
                    companySite.text = resultModel.companyInfo.siteUrl
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
                    hideKeyboardAndClearFocus(v)
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }

    private fun initSearchView(searchView: SearchViewBinding) {
        searchView.enterTickerNameField.addTextChangedListener {
            searchView.clearIcon.isInvisible = it?.isEmpty() ?: false
        }
        searchView.enterTickerNameField.setOnEditorActionListener { v, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val enteredTickerText = searchView.enterTickerNameField.text.toString()
                viewModel.setEvent(AggregatorEvent.OnSubmitTickerButtonClicked(enteredTickerText))
                hideKeyboardAndClearFocus(v as EditText)
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
        searchView.clearIcon.setOnClickListener {
            searchView.enterTickerNameField.text.clear()
        }
    }

    private fun initViewPagerWithTabs(viewPager: ViewPager2, tabLayout: TabLayout) {
        viewPager.adapter = ViewPagerFragmentAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.setText(R.string.tab_technical_indicators)
                1 -> tab.setText(R.string.tab_technical_analysis)
            }
        }.attach()
    }

    private fun hideKeyboardAndClearFocus(editText: EditText) {
        editText.clearFocus()
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(editText.windowToken, 0)
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
