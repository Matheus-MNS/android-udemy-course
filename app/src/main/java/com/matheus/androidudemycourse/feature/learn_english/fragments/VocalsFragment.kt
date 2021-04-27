package com.matheus.androidudemycourse.feature.learn_english.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matheus.androidudemycourse.databinding.FragmentVocalsBinding

class VocalsFragment : Fragment() {

    private lateinit var binding: FragmentVocalsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentVocalsBinding.inflate(inflater,container,false)
        return binding.root
    }

}