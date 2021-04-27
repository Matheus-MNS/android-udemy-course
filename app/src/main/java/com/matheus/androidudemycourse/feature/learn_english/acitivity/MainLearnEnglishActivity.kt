package com.matheus.androidudemycourse.feature.learn_english.acitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.matheus.androidudemycourse.databinding.ActivityMainLearnEnglishBinding
import com.matheus.androidudemycourse.feature.learn_english.adapter.LearnEnglishAdapter

class MainLearnEnglishActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainLearnEnglishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainLearnEnglishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.learnEnglishViewPager.adapter = LearnEnglishAdapter(supportFragmentManager,this)
        binding.learnEnglishTabLayout.setupWithViewPager(binding.learnEnglishViewPager)
    }
}