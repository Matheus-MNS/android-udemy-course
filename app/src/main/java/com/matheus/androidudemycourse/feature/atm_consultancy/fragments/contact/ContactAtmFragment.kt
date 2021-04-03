package com.matheus.androidudemycourse.feature.atm_consultancy.fragments.contact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.FragmentContactAtmBinding

class ContactAtmFragment : Fragment() {

    private lateinit var binding: FragmentContactAtmBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContactAtmBinding.inflate(inflater,container,false)
        return binding.root
    }


}