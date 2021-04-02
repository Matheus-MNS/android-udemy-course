package com.matheus.androidudemycourse.feature.atm_consultancy.fragments.clients

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.FragmentClientsBinding


class ClientsFragment : Fragment() {

    private lateinit var binding: FragmentClientsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentClientsBinding.inflate(inflater, container, false)
        return binding.root
    }
}