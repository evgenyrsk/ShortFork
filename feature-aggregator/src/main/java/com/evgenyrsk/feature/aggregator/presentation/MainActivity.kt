package com.evgenyrsk.feature.aggregator.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.evgenyrsk.feature.aggregator.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private val viewBinding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val animator = ViewPager2.PageTransformer { page, position ->
        val absPos = abs(position)
        page.apply {
            rotation = position * 360
            translationY = absPos * 500f
            translationX = 0f
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(viewBinding.root)

        TabLayoutMediator(
            viewBinding.tabs,
            viewBinding.viewPager
        ) { tab, position ->
        }.attach()

        viewBinding.viewPager.adapter = ViewPagerFragmentAdapter(this)
    }

    class ViewPagerFragmentAdapter(host: FragmentActivity) : FragmentStateAdapter(host) {

        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> AggregatorFragment()
                else -> Fragment()
            }
        }
    }
}
