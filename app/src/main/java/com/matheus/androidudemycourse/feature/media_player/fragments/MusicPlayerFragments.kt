package com.matheus.androidudemycourse.feature.media_player.fragments

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.FragmentMusicPlayerFragmentsBinding

class MusicPlayerFragments : Fragment() {

    private lateinit var binding: FragmentMusicPlayerFragmentsBinding
    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMusicPlayerFragmentsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mediaPlayer = MediaPlayer.create(context,R.raw.daft_punk_technologic)
        binding.playMusicButton.setOnClickListener {
            playMusic()
        }

        binding.pauseMusicButton.setOnClickListener {
            pauseMusic()
        }

        binding.stopMusicButton.setOnClickListener {
            stopMusic()
        }
    }

    private fun playMusic() {
        if(mediaPlayer!=null){
            mediaPlayer.start()
        }
    }
    private fun pauseMusic(){
        if (mediaPlayer.isPlaying){
            mediaPlayer.pause()
        }
    }
    private fun stopMusic(){
        if (mediaPlayer.isPlaying){
            mediaPlayer.stop()
            mediaPlayer = MediaPlayer.create(context,R.raw.daft_punk_technologic)
        }
    }
}