package com.matheus.androidudemycourse.feature.heads_or_tails

import android.os.Bundle
import android.view.*
import android.widget.Toolbar
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
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

        setHasOptionsMenu(true)
        flipCoin()
    }

    private fun flipCoin() {
        val coinSide = Random.nextInt(0, 5)

        return if (coinSide == 0)
            binding.resultCoinImageView.setImageResource(R.drawable.heads_coin)
        else
            binding.resultCoinImageView.setImageResource(R.drawable.tails_coin)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                activity?.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}