package com.matheus.androidudemycourse.feature.media_player.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.matheus.androidudemycourse.databinding.ActivityMediaPlayerBinding

class MediaPlayerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMediaPlayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMediaPlayerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}