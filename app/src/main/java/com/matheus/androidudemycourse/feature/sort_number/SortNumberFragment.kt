package com.matheus.androidudemycourse.feature.sort_number

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.FragmentSortNumberBinding
import kotlin.random.Random

class SortNumberFragment : Fragment() {

    private lateinit var binding: FragmentSortNumberBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSortNumberBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sortButton.setOnClickListener {
            sortNumber()
        }
    }

    private fun sortNumber() {
        val number = Random.nextInt(0, 11)
        binding.resultTextView.text = getString(R.string.result_text, number.toString())
    }
}