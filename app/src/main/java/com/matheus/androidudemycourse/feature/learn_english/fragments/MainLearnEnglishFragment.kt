package com.matheus.androidudemycourse.feature.learn_english.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matheus.androidudemycourse.databinding.FragmentMainLearnEnglishBinding
import com.matheus.androidudemycourse.feature.learn_english.adapter.LearnEnglishAdapter

class MainLearnEnglishFragment : Fragment() {

    private lateinit var binding: FragmentMainLearnEnglishBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainLearnEnglishBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            learnEnglishViewPager.adapter = activity?.let {
                LearnEnglishAdapter(childFragmentManager, it)
            }
            learnEnglishTabLayout.setupWithViewPager(binding.learnEnglishViewPager)
        }
    }
}