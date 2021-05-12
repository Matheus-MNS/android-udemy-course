package com.matheus.androidudemycourse.feature.learn_english.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.matheus.androidudemycourse.databinding.FragmentMainLearnEnglishBinding
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.feature.learn_english.adapter.LearnEnglishAdapter
import com.matheus.androidudemycourse.utils.VisibilityActionEnum.*
import com.matheus.androidudemycourse.utils.changeStatusBarColor
import com.matheus.androidudemycourse.utils.handleActionBarVisibility

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

        setupView()

        with(binding) {
            learnEnglishViewPager.adapter = activity?.let {
                LearnEnglishAdapter(childFragmentManager, it)
            }
            learnEnglishTabLayout.setupWithViewPager(binding.learnEnglishViewPager)
        }
    }

    private fun setupView() {
        changeStatusBarColor(R.color.color_primary_dark_learn_english)

        handleActionBarVisibility(HIDE)
        with(binding) {
            learnEnglishToolbar.title = getString(R.string.learn_english)
            learnEnglishToolbar.setNavigationIcon(R.drawable.ic_arrow_back)
            learnEnglishToolbar.setNavigationOnClickListener {
                requireActivity().onBackPressed()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handleActionBarVisibility(SHOW)
        changeStatusBarColor(R.color.purple_700)
    }
}