package com.matheus.androidudemycourse.feature.heads_or_tails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        binding = FragmentHeadsOrTailsResultBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        flipCoin()

//        binding.returnButon.setOnClickListener {
//
//            activity?.supportFragmentManager?.beginTransaction()
//                ?.replace(R.id.nav_host_fragment, HeadsOrTailsResultFragment())
//                ?.commit()
//        }
    }

    private fun flipCoin(){
        val r =  Random.nextInt(0,1)

        return if (r == 0)
            binding.resultCoinImageView.setImageResource(R.drawable.heads_coin)
        else
            binding.resultCoinImageView.setImageResource(R.drawable.tails_coin)
    }
}