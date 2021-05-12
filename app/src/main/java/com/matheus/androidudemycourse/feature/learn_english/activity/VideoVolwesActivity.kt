package com.matheus.androidudemycourse.feature.learn_english.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.matheus.androidudemycourse.databinding.ActivityVideoVolwesBinding

class VideoVolwesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVideoVolwesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoVolwesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}