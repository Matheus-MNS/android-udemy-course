package com.matheus.androidudemycourse.feature.atm_consultancy.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.matheus.androidudemycourse.R
import mehdi.sakout.aboutpage.AboutPage

class AboutAtmFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return AboutPage(context)
            .isRTL(false)
            .enableDarkMode(false)
            .setImage(R.drawable.logo_atm)
            .setDescription(getString(R.string.atm_description))
            .addGroup(getString(R.string.submenu_title))
            .addEmail(getString(R.string.atm_email))
            .addGroup(getString(R.string.group_social))
            .addFacebook("matheus.mendes.33633")
            .addGitHub("Matheus-MNS")
            .create()
    }
}