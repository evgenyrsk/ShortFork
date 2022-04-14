package com.evgenyrsk.feature.aggregator.presentation.description

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.evgenyrsk.feature.aggregator.databinding.FragmentCompanyDescriptionBinding

/**
 * @author Evgeny Rasskazov
 * Created on 18.01.2022
 */
class CompanyDescriptionFragment : Fragment() {

    private lateinit var binding: FragmentCompanyDescriptionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCompanyDescriptionBinding.inflate(inflater)
        return binding.root
    }

    companion object {
        fun newInstance(): CompanyDescriptionFragment = CompanyDescriptionFragment()
    }
}