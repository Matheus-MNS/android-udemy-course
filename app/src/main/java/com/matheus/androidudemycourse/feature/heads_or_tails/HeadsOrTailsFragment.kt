package com.matheus.androidudemycourse.feature.heads_or_tails

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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

            findNavController().navigate(
                HeadsOrTailsFragmentDirections.actionHeadsOrTailsFragmentToHeadsOrTailsResultFragment()
            )
        }
    }
}