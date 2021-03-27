package com.matheus.androidudemycourse.feature.heads_or_tails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.FragmentHeadsorTailsBinding

class HeadsOrTailsFragment : Fragment() {

    private lateinit var binding: FragmentHeadsorTailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHeadsorTailsBinding.inflate(inflater,container,false)
        return binding.root
    }

}