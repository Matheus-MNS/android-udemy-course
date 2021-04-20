package com.matheus.androidudemycourse.feature.media_player.activities

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.ActivityMediaPlayerBinding
import com.matheus.androidudemycourse.databinding.ActivityVideoPlayerBinding

class VideoPlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVideoPlayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
    }

    private fun setupView() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        val videoView = binding.playerVideoView
        val mediaController = MediaController(this)

        mediaController.setAnchorView(videoView)
        handleVideoView(videoView, mediaController)
    }

    private fun handleVideoView(videoView: VideoView, mediaController: MediaController) {
        videoView.apply {
            setMediaController(mediaController)
            setVideoURI(Uri.parse("android.resource://$packageName/${R.raw.opening_rick_and_morty}"))
            requestFocus()
            start()
        }
    }
}