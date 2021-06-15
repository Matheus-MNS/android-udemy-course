package com.matheus.androidudemycourse.feature.task_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.FragmentTaskListAddBinding

class TaskListAdd : Fragment() {

 private lateinit var binding: FragmentTaskListAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskListAddBinding.inflate(inflater,container,false)
        return binding.root
    }

}