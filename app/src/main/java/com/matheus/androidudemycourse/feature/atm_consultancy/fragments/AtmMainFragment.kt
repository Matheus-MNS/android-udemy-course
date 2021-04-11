package com.matheus.androidudemycourse.feature.atm_consultancy.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matheus.androidudemycourse.databinding.FragmentAtmMainBinding

class AtmMainFragment : Fragment() {

    private lateinit var binding: FragmentAtmMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAtmMainBinding.inflate(inflater,container,false)
        return binding.root
    }
}