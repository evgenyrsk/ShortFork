package com.evgenyrsk.feature.aggregator.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.evgenyrsk.core.presentation.mvi.viewmodel.GenericSavedStateViewModelFactory
import com.evgenyrsk.feature.aggregator.databinding.FragmentAggregatorBinding
import com.evgenyrsk.feature.aggregator.di.AggregatorComponentHolder
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * @author Evgeny Rasskazov
 */
class AggregatorFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: AggregatorViewModelFactory

    private val viewModel: AggregatorViewModel by viewModels {
        GenericSavedStateViewModelFactory(viewModelFactory, this)
    }

    private lateinit var binding: FragmentAggregatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AggregatorComponentHolder.get().inject(this)
        initObservers()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAggregatorBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.acceptButton.setOnClickListener {
            val companyTicker = binding.tickerInput.text.toString()
            viewModel.setEvent(AggregatorEvent.OnShowButtonClicked(companyTicker))
        }
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
                    Log.d("RESULT_RESULT", "result: ${state.shortInfoState.model.ticker}")
                }
            }
        }.launchIn(lifecycleScope)

        viewModel.effect.onEach { effect ->
            when (effect) {
                is AggregatorEffect.ShowToast -> {
                    binding.progressBar.hide()
                    Toast.makeText(
                        this@AggregatorFragment.requireContext(),
                        "ERROR",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is AggregatorEffect.ShowSnakeBar -> {
                    // todo
                }
            }
        }.launchIn(lifecycleScope)
    }
}
