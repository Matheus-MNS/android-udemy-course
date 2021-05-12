package com.matheus.androidudemycourse.feature.learn_english.fragments

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.FragmentNumbersBinding

class NumbersFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentNumbersBinding
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNumbersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        appllyClick()
    }

    private fun appllyClick() {
        with(binding) {
            numberOneImageView.setOnClickListener(this@NumbersFragment)
            numberTwoImageView.setOnClickListener(this@NumbersFragment)
            numberThreeImageView.setOnClickListener(this@NumbersFragment)
            numberFourImageView.setOnClickListener(this@NumbersFragment)
            numberFiveImageView.setOnClickListener(this@NumbersFragment)
            numberSixImageView.setOnClickListener(this@NumbersFragment)
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.numberOneImageView -> playSound(R.raw.one)
            R.id.numberTwoImageView -> playSound(R.raw.two)
            R.id.numberThreeImageView -> playSound(R.raw.three)
            R.id.numberFourImageView -> playSound(R.raw.four)
            R.id.numberFiveImageView -> playSound(R.raw.five)
            R.id.numberSixImageView -> playSound(R.raw.six)
        }
    }

    private fun playSound(Sound: Int) {
        mediaPlayer = MediaPlayer.create(activity, Sound)

        mediaPlayer.apply {
            start()
            setOnCompletionListener {
                release()
            }
        }
    }
}