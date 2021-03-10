package com.matheus.androidudemycourse.feature.daily_quotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.FragmentDailyQuotesBinding


class DailyQuotesFragment : Fragment() {

    private lateinit var binding: FragmentDailyQuotesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDailyQuotesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




    }


}