package com.matheus.androidudemycourse.feature.learn_english.adapter

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.feature.learn_english.fragments.AnimalsFragment
import com.matheus.androidudemycourse.feature.learn_english.fragments.NumbersFragment
import com.matheus.androidudemycourse.feature.learn_english.fragments.VocalsFragment

class LearnEnglishAdapter(fragmentManager: FragmentManager, private val activity: Activity):
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                AnimalsFragment()
            }
            1 -> {
                NumbersFragment()
            }
            else -> {
                VocalsFragment()
            }
        }
    }
    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> {
                activity.getString(R.string.fragmet_animals)
            }
            1 -> {
                activity.getString(R.string.fragmet_nubers)
            }
            else -> {
                activity.getString(R.string.fragmet_vocals)
            }
        }
    }

}