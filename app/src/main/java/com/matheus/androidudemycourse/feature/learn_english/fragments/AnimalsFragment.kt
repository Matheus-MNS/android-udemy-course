package com.matheus.androidudemycourse.feature.learn_english.fragments

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.FragmentAnimalsBinding

class AnimalsFragment : Fragment() {

    private lateinit var binding: FragmentAnimalsBinding
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnimalsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        applyClick()
    }

    private fun applyClick() {
        with(binding) {
            dogImageView.setOnClickListener { playSound(R.raw.dog) }
            catImageView.setOnClickListener { playSound(R.raw.cat) }
            lionImageView.setOnClickListener { playSound(R.raw.lion) }
            monkeyImageView.setOnClickListener { playSound(R.raw.monkey) }
            sheepImageView.setOnClickListener { playSound(R.raw.sheep) }
            cowImageView.setOnClickListener { playSound(R.raw.cow) }
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