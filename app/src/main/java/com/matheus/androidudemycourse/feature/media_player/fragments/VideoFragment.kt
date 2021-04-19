package com.matheus.androidudemycourse.feature.media_player.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matheus.androidudemycourse.databinding.FragmentVideoBinding
import com.matheus.androidudemycourse.feature.media_player.activities.VideoPlayerActivity

class VideoFragment : Fragment() {

    private lateinit var binding: FragmentVideoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVideoBinding.inflate(inflater, container, false)
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



