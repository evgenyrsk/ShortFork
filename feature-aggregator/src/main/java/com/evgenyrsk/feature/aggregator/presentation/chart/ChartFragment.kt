package com.evgenyrsk.feature.aggregator.presentation.chart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.evgenyrsk.feature.aggregator.databinding.FragmentChartBinding

/**
 * @author Evgeny Rasskazov
 * Created on 18.01.2022
 */
class ChartFragment: Fragment() {

    private lateinit var binding: FragmentChartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChartBinding.inflate(inflater)
        return binding.root
    }
}