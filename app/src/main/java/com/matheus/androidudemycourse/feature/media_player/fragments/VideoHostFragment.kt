package com.matheus.androidudemycourse.feature.media_player.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.FragmentVideoHostBinding

@Suppress("UNREACHABLE_CODE")
class VideoHostFragment : Fragment() {

    private lateinit var binding: FragmentVideoHostBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVideoHostBinding.inflate(inflater, container, false)
        return binding.root

        setupView()
    }

    private fun setupView() {
        requireActivity().window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val videoView = binding.videoHostvideoView
        val mediaController = MediaController(context)

        mediaController.setAnchorView(videoView)
        handleVideoView(videoView, mediaController)
    }

    private fun handleVideoView(videoView: VideoView, mediaController: MediaController) {
        videoView.apply {
            setMediaController(mediaController)
            setVideoPath("android.resource://${requireActivity().packageName}/${R.raw.opening_rick_and_morty}")
            start()
        }
    }
}