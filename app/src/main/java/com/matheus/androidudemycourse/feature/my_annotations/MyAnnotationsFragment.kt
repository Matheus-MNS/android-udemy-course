package com.matheus.androidudemycourse.feature.my_annotations

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.FragmentMyAnnotationsBinding
import com.matheus.androidudemycourse.utils.VisibilityActionEnum
import com.matheus.androidudemycourse.utils.changeStatusBarColor
import com.matheus.androidudemycourse.utils.handleActionBarVisibility
import com.matheus.androidudemycourse.utils.snackBar


const val NOTE_KEY = "note"

class MyAnnotationsFragment : Fragment() {

    private lateinit var binding: FragmentMyAnnotationsBinding
    private lateinit var sharedPreferences: SharedPreferences

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

        binding.backHomeImageView.setOnClickListener {
            activity?.onBackPressed()
        }
        binding.saveAnnotationsFloatButton.setOnClickListener {
            //validateEmpty()
        }

    }

//    private fun validateEmpty() {
//        if (binding.annotationsTextInput.text.isNullOrEmpty()) {
//            snackBar(requireView(), R.string.empty_field, Snackbar.LENGTH_LONG)
//        } else {
//            saveSharedPreferences()
//            snackBar(requireView(), R.string.save_annotations, Snackbar.LENGTH_LONG)
//        }
//    }



    private fun setupView() {
        changeStatusBarColor(R.color.dark_brown)

        handleActionBarVisibility(VisibilityActionEnum.HIDE)
        binding.myAnnotationsToolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as AppCompatActivity).supportActionBar?.show()
        changeStatusBarColor(R.color.purple_700)
    }
}