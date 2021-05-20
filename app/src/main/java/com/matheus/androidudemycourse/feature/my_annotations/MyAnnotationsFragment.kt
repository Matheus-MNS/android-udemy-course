package com.matheus.androidudemycourse.feature.my_annotations
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.FragmentMyAnnotationsBinding
import com.matheus.androidudemycourse.utils.VisibilityActionEnum
import com.matheus.androidudemycourse.utils.changeStatusBarColor
import com.matheus.androidudemycourse.utils.handleActionBarVisibility


class MyAnnotationsFragment : Fragment() {

    private lateinit var binding: FragmentMyAnnotationsBinding

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


    }

    private fun setupView() {
        changeStatusBarColor(R.color.dark_brown)

        handleActionBarVisibility(VisibilityActionEnum.HIDE)
        with(binding) {
            myAnnotationsToolbar.setNavigationOnClickListener {
                activity?.onBackPressed()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as AppCompatActivity).supportActionBar?.show()
        changeStatusBarColor(R.color.purple_700)
    }
}