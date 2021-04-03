package com.matheus.androidudemycourse.feature.atm_consultancy.fragments.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matheus.androidudemycourse.databinding.FragmentAboutAtmBinding

class AboutAtmFragment : Fragment() {

    private lateinit var binding: FragmentAboutAtmBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutAtmBinding.inflate(inflater, container, false)
        return binding.root
    }
}