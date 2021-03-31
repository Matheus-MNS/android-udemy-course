package com.matheus.androidudemycourse.feature.heads_or_tails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.FragmentHeadsOrTailsBinding


class HeadsOrTailsFragment : Fragment() {

    private lateinit var binding: FragmentHeadsOrTailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHeadsOrTailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.playButton.setOnClickListener {

            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.nav_host_fragment, HeadsOrTailsResultFragment())
                ?.addToBackStack("HeadsOrTailsResultFragment")
                ?.commit()
        }
    }
}