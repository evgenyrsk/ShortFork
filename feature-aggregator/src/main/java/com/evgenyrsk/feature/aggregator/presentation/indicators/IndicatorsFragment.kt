package com.evgenyrsk.feature.aggregator.presentation.indicators

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.evgenyrsk.core.presentation.mvi.viewmodel.GenericSavedStateViewModelFactory
import com.evgenyrsk.feature.aggregator.databinding.FragmentAggregatorBinding
import com.evgenyrsk.feature.aggregator.di.AggregatorComponentHolder
import com.evgenyrsk.feature.aggregator.presentation.AggregatorEffect
import com.evgenyrsk.feature.aggregator.presentation.AggregatorViewModel
import com.evgenyrsk.feature.aggregator.presentation.AggregatorViewModelFactory
import com.evgenyrsk.feature.aggregator.presentation.ShortInfoState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * @author Evgeny Rasskazov
 */
class IndicatorsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: AggregatorViewModelFactory

    private val viewModel: AggregatorViewModel by activityViewModels {
        GenericSavedStateViewModelFactory(viewModelFactory, requireActivity())
    }

    private lateinit var binding: FragmentAggregatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AggregatorComponentHolder.get().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAggregatorBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()
    }

    private fun initObservers() {
        viewModel.uiState.onEach { state ->
            when (state.shortInfoState) {
                is ShortInfoState.Idle -> {
                    binding.progressBar.hide()
                }
                is ShortInfoState.Loading -> {
                    binding.progressBar.show()
                }
                is ShortInfoState.Loaded -> {
                    binding.progressBar.hide()
                    Toast.makeText(
                        requireContext(),
                        "Result: ${state.shortInfoState.model.ticker}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }.launchIn(lifecycleScope)

        viewModel.effect.onEach { effect ->
            when (effect) {
                is AggregatorEffect.ShowToast -> {
                    binding.progressBar.hide()
                    Toast.makeText(
                        this@IndicatorsFragment.requireContext(),
                        "ERROR",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }.launchIn(lifecycleScope)
    }
}
