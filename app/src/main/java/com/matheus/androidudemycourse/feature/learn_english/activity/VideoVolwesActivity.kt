package com.matheus.androidudemycourse.feature.learn_english.activity

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.ActivityVideoVolwesBinding

class VideoVolwesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVideoVolwesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoVolwesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
    }

    private fun setupView() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val videoView = binding.playerVolwesVideoView
        val mediaController = object : MediaController(this){
            override fun hide() {
                super.hide()
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
            }
        }

        mediaController.setAnchorView(videoView)
        handleVideoView(videoView, mediaController)
    }

    private fun handleVideoView(videoView: VideoView, mediaController: MediaController) {
        videoView.apply {
            setMediaController(mediaController)
            setVideoURI(Uri.parse("android.resource://$packageName/${R.raw.vowel_song_best_phonics}"))
            requestFocus()
            start()
        }
    }
}