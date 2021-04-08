package com.matheus.androidudemycourse.feature.media_player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.ActivityMediaPlayerBinding
import com.matheus.androidudemycourse.feature.media_player.fragments.MusicPlayerFragments

class MediaPlayerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMediaPlayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMediaPlayerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.musicButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.mainFrameLayout,MusicPlayerFragments())
                addToBackStack(null)
                commit()
            }
        }
    }
}