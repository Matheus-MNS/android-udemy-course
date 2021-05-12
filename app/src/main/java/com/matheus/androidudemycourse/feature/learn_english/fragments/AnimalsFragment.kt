package com.matheus.androidudemycourse.feature.learn_english.fragments

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.FragmentAnimalsBinding

class AnimalsFragment : Fragment(), View.OnClickListener {

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

        appllyClick()
    }

    private fun appllyClick() {
        with(binding) {
            dogImageView.setOnClickListener(this@AnimalsFragment)
            catImageButton.setOnClickListener(this@AnimalsFragment)
            lionImageView.setOnClickListener(this@AnimalsFragment)
            monkeyImageView.setOnClickListener(this@AnimalsFragment)
            sheepImageView.setOnClickListener(this@AnimalsFragment)
            cowImageView.setOnClickListener(this@AnimalsFragment)
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.dogImageView -> playSound(R.raw.dog)
            R.id.catImageButton -> playSound(R.raw.cat)
            R.id.lionImageView -> playSound(R.raw.lion)
            R.id.monkeyImageView -> playSound(R.raw.monkey)
            R.id.sheepImageView -> playSound(R.raw.sheep)
            R.id.cowImageView -> playSound(R.raw.cow)
        }
    }

    private fun playSound(Sound: Int){
        mediaPlayer = MediaPlayer.create(activity,Sound)

        mediaPlayer.apply {
            start()
            setOnCompletionListener {
                release()
            }
        }
    }
}