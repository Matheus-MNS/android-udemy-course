package com.matheus.androidudemycourse.feature.learn_english.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.FragmentMainLearEnglishBinding
import com.matheus.androidudemycourse.feature.learn_english.adapter.LearnEnglishAdapter

class MainLearEnglishFragment : Fragment() {

    private lateinit var binding: FragmentMainLearEnglishBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainLearEnglishBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        with(binding) {
            learnEnglishViewPager.adapter = activity?.let {
                LearnEnglishAdapter(childFragmentManager, it)
            }
            learnEnglishTabLayout.setupWithViewPager(learnEnglishViewPager)
        }
    }
}