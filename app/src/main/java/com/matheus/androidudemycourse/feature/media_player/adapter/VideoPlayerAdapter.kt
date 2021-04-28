package com.matheus.androidudemycourse.feature.media_player.adapter

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.feature.media_player.fragments.MusicPlayerFragment
import com.matheus.androidudemycourse.feature.media_player.fragments.VideoPlayerFragment

class VideoPlayerAdapter(fragmentManager: FragmentManager, private val activity: Activity) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> MusicPlayerFragment()
            else -> VideoPlayerFragment()
        }
    }

    override fun getCount(): Int = 2

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> activity.getString(R.string.music)
            else -> activity.getString(R.string.video)
        }
    }
}