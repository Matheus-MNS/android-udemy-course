package com.matheus.androidudemycourse.feature.learn_english.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matheus.androidudemycourse.databinding.FragmentVowelsBinding
import com.matheus.androidudemycourse.feature.learn_english.activity.VideoVowelsActivity

class VowelsFragment : Fragment() {

    private lateinit var binding: FragmentVowelsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVowelsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.playVideoImageView.setOnClickListener {
            navigateToVideoPlayerActivity()
        }
    }

    private fun navigateToVideoPlayerActivity() {
        val intent = Intent(activity, VideoVowelsActivity::class.java)
        startActivity(intent)
    }

}