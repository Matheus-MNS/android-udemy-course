package com.matheus.androidudemycourse.feature.media_player.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matheus.androidudemycourse.databinding.FragmentVideoPlayerBinding
import com.matheus.androidudemycourse.feature.media_player.activities.VideoPlayerActivity

class VideoPlayerFragment : Fragment() {

    private lateinit var binding: FragmentVideoPlayerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVideoPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.playVideoImageView.setOnClickListener() {
            navigateToVideoPlayerActivity()
        }
    }

    private fun navigateToVideoPlayerActivity() {
        val intent = Intent(activity, VideoPlayerActivity::class.java)
        startActivity(intent)
    }
}



