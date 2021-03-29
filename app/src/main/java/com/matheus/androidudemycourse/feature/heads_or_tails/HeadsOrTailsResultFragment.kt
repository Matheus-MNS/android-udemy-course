package com.matheus.androidudemycourse.feature.heads_or_tails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.FragmentHeadsOrTailsResultBinding
import kotlin.random.Random

class HeadsOrTailsResultFragment : Fragment() {

    private lateinit var binding: FragmentHeadsOrTailsResultBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHeadsOrTailsResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleOnBackPressed()
        flipCoin()

        binding.returnButon.setOnClickListener {
          popBackStack()
        }
    }

    private fun flipCoin() {
        val r = Random.nextInt(0, 5)

        return if (r == 0)
            binding.resultCoinImageView.setImageResource(R.drawable.heads_coin)
        else
            binding.resultCoinImageView.setImageResource(R.drawable.tails_coin)
    }

    private fun handleOnBackPressed() {

        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                popBackStack()
            }
        })
    }

    private fun popBackStack(){
        activity?.supportFragmentManager?.popBackStack(
            "HeadsOrTailsResultFragment",
            FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
    }
}