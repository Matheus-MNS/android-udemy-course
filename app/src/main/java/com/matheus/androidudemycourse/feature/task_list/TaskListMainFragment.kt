package com.matheus.androidudemycourse.feature.task_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.FragmentTaskListMainBinding
import com.matheus.androidudemycourse.utils.VisibilityActionEnum
import com.matheus.androidudemycourse.utils.changeStatusBarColor
import com.matheus.androidudemycourse.utils.handleActionBarVisibility

class TaskListMainFragment : Fragment() {

    private lateinit var binding: FragmentTaskListMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskListMainBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()

        binding.backHomeImageView.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun setupView() {
        changeStatusBarColor(R.color.dark_red)
        handleActionBarVisibility(VisibilityActionEnum.HIDE)

        binding.taskListToolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        handleActionBarVisibility(VisibilityActionEnum.SHOW)
        changeStatusBarColor(R.color.purple_700)
    }

}