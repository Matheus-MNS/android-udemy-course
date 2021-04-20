package com.matheus.androidudemycourse.feature.media_player.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.matheus.androidudemycourse.databinding.ActivityMediaPlayerBinding
import com.matheus.androidudemycourse.feature.media_player.fragments.MusicPlayerFragment
import com.matheus.androidudemycourse.feature.media_player.fragments.VideoPlayerFragment
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems

class MediaPlayerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMediaPlayerBinding
    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: SmartTabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMediaPlayerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewPager = binding.viewPager
        tabLayout = binding.viewPagerTab

        supportActionBar?.elevation = 0f

        val adapter = FragmentPagerItemAdapter(
            supportFragmentManager, FragmentPagerItems.with(this)
                .add("Music", MusicPlayerFragment::class.java)
                .add("Video", VideoPlayerFragment::class.java)
                .create()
        )
        viewPager.adapter = adapter
        tabLayout.setViewPager(viewPager)

    }
}