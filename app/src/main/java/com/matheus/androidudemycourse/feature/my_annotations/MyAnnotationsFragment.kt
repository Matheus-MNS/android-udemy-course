package com.matheus.androidudemycourse.feature.my_annotations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.FragmentMyAnnotationsBinding
import com.matheus.androidudemycourse.utils.VisibilityActionEnum
import com.matheus.androidudemycourse.utils.changeStatusBarColor
import com.matheus.androidudemycourse.utils.handleActionBarVisibility
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyAnnotationsFragment : Fragment() {

    private lateinit var binding: FragmentMyAnnotationsBinding
    private val viewModel: MyAnnotationsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyAnnotationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()

        with(binding) {
            backHomeImageView.setOnClickListener {
                activity?.onBackPressed()
            }
            saveAnnotationsFloatButton.setOnClickListener {
                viewModel.saveStringOnPreferences(annotationsTextInput.text.toString())
            }
        }
    }

    private fun setupView() {
        changeStatusBarColor(R.color.dark_brown)
        handleActionBarVisibility(VisibilityActionEnum.HIDE)

        binding.myAnnotationsToolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handleActionBarVisibility(VisibilityActionEnum.SHOW)
        changeStatusBarColor(R.color.purple_700)
    }
}