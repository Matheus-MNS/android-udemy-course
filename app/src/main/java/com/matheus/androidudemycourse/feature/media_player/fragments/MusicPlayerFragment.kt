package com.matheus.androidudemycourse.feature.media_player.fragments

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.FragmentMusicPlayerBinding

class MusicPlayerFragment : Fragment() {

    private lateinit var binding: FragmentMusicPlayerBinding
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var audiomanger: AudioManager
    private var musicId = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMusicPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        musicId = R.raw.daft_punk_harder_better_faster
        setupMusic()
        volumeController()
        setupButtonMedia()
    }

    private fun setupMusic() {
        mediaPlayer = MediaPlayer.create(context, musicId)
    }

    private fun setupButtonMedia() {
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

    private fun volumeController() {
        audiomanger =
            activity?.applicationContext?.getSystemService(Context.AUDIO_SERVICE) as AudioManager

        val maxVolume = audiomanger.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        val currentVolume = audiomanger.getStreamVolume(AudioManager.STREAM_MUSIC)

        binding.volumeSeekBar.max = maxVolume
        binding.volumeSeekBar.progress = currentVolume

        binding.volumeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                audiomanger.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
    }

    private fun playMusic() {
        mediaPlayer.start()
    }

    private fun pauseMusic() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
        }
    }

    private fun stopMusic() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
            setupMusic()
        }
    }

    override fun onStop() {
        super.onStop()
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
            mediaPlayer.release()
        }
    }
}