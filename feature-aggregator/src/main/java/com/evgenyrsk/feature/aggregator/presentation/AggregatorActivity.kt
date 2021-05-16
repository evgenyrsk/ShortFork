package com.evgenyrsk.feature.aggregator.presentation

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.evgenyrsk.core.presentation.mvi.viewmodel.GenericSavedStateViewModelFactory
import com.evgenyrsk.feature.aggregator.R
import com.evgenyrsk.feature.aggregator.databinding.ActivityMainBinding
import com.evgenyrsk.feature.aggregator.di.AggregatorComponentHolder
import com.evgenyrsk.feature.aggregator.presentation.indicators.IndicatorsFragment
import com.google.android.material.tabs.TabLayoutMediator
import javax.inject.Inject
import kotlin.math.abs

class AggregatorActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: AggregatorViewModelFactory

    private val viewBinding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: AggregatorViewModel by viewModels {
        GenericSavedStateViewModelFactory(viewModelFactory, this)
    }

    private val animator: ViewPager2.PageTransformer = ViewPager2.PageTransformer { page, position ->
        val absPos = abs(position)
        page.apply {
            rotation = position * 360
            translationY = absPos * 500f
            translationX = 0f
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AggregatorComponentHolder.get().inject(this)

        setContentView(viewBinding.root)
        setSupportActionBar(viewBinding.toolbar)
        viewBinding.toolbar.setTitle(R.string.app_name)

        viewBinding.viewPager.adapter = ViewPagerFragmentAdapter(this)

        TabLayoutMediator(viewBinding.tabs, viewBinding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.setText(R.string.tab_technical_indicators)
                1 -> tab.setText(R.string.tab_technical_analysis)
            }
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager

        val searchItem = menu?.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as? SearchView
        searchView?.let {
            it.setSearchableInfo(searchManager.getSearchableInfo(this.componentName))
            it.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextChange(newText: String): Boolean {
                    return true
                }

                override fun onQueryTextSubmit(query: String): Boolean {
                    viewModel.setEvent(AggregatorEvent.OnSubmitTickerButtonClicked(query))
                    return true
                }
            })
        }

        return super.onPrepareOptionsMenu(menu)
    }

    class ViewPagerFragmentAdapter(host: FragmentActivity) : FragmentStateAdapter(host) {

        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> IndicatorsFragment()
                else -> Fragment()
            }
        }
    }
}
