package com.matheus.androidudemycourse.feature.my_annotations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.FragmentMyAnnotationsBinding
import com.matheus.androidudemycourse.utils.VisibilityActionEnum
import com.matheus.androidudemycourse.utils.changeStatusBarColor
import com.matheus.androidudemycourse.utils.handleActionBarVisibility
import com.matheus.androidudemycourse.utils.snackBar
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
        handleObserver()

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

    private fun handleObserver() {
        val note = Observer<String> {
            binding.annotationsTextInput.setText(it)
        }

        val error = Observer<Boolean> {
            handleSnackBar(it)
        }

        viewModel.note.observe(viewLifecycleOwner, note)
        viewModel.error.observe(viewLifecycleOwner, error)
    }

    private fun handleSnackBar(error: Boolean) {
        if (error) {
            snackBar(requireView(), R.string.empty_field_error_message, Snackbar.LENGTH_LONG)
        } else {
            snackBar(requireView(), R.string.annotations_saved_message, Snackbar.LENGTH_LONG)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handleActionBarVisibility(VisibilityActionEnum.SHOW)
        changeStatusBarColor(R.color.purple_700)
    }
}