package com.evgenyrsk.feature.aggregator.presentation.indicators

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.evgenyrsk.core.presentation.mvi.MviView
import com.evgenyrsk.core.presentation.mvi.viewmodel.GenericSavedStateViewModelFactory
import com.evgenyrsk.core.presentation.mvi.viewmodel.ViewModelAssistedFactory
import com.evgenyrsk.feature.aggregator.databinding.FragmentAggregatorBinding
import com.evgenyrsk.feature.aggregator.di.AggregatorComponentHolder
import com.evgenyrsk.feature.aggregator.presentation.AggregatorEffect
import com.evgenyrsk.feature.aggregator.presentation.AggregatorState
import com.evgenyrsk.feature.aggregator.presentation.AggregatorViewModel
import com.evgenyrsk.feature.aggregator.presentation.indicators.model.IndicatorsInfoState
import com.evgenyrsk.feature.aggregator.presentation.indicators.recycler.IndicatorsListAdapter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * @author Evgeny Rasskazov
 */
internal class IndicatorsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelAssistedFactory<AggregatorViewModel>

    private val viewModel: AggregatorViewModel by activityViewModels {
        GenericSavedStateViewModelFactory(viewModelFactory, requireActivity())
    }
    private val recyclerAdapter: IndicatorsListAdapter by lazy {
        IndicatorsListAdapter { indicatorItem ->
            Toast.makeText(requireContext(), indicatorItem.name, Toast.LENGTH_SHORT).show()
        }
    }

    private lateinit var binding: FragmentAggregatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AggregatorComponentHolder.getComponent().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAggregatorBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycler.adapter = recyclerAdapter

        initObservers()
    }

    private fun initObservers() {
        viewModel.uiState.onEach { state ->
            when (state.indicatorsInfoState) {
                is IndicatorsInfoState.Idle -> {
                    binding.progressBar.hide()
                }
                is IndicatorsInfoState.Loading -> {
                    binding.progressBar.show()
                }
                is IndicatorsInfoState.Loaded -> {
                    binding.progressBar.hide()
                    recyclerAdapter.submitList(state.indicatorsInfoState.model.indicators)
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

    companion object {
        fun newInstance(): IndicatorsFragment = IndicatorsFragment()
    }
}
