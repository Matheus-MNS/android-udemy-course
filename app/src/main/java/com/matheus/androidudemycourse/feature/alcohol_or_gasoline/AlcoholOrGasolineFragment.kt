package com.matheus.androidudemycourse.feature.alcohol_or_gasoline

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.FragmentAlcoholOrGasolineBinding

class AlcoholOrGasolineFragment : Fragment() {

    private lateinit var binding: FragmentAlcoholOrGasolineBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlcoholOrGasolineBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClick()
    }

    private fun setupClick() {
        binding.calculatorButtom.setOnClickListener {
            calculateFuelPrice()
        }
    }

    private fun showResult(value: Double) {
        if (value >= 0.7) {
            binding.resultAlcoholOrGasolineTextView.text =
                getString(R.string.gasoline_better_text)
        } else {
            binding.resultAlcoholOrGasolineTextView.text =
                getString(R.string.alcohol_better_text)
        }
    }

    private fun calculateFuelPrice() {
        if (validateInformation()) {
            val value = binding.alcoholTextInputEditText.text.toString()
                .toDouble() / binding.gasolineTextInputEditText.text.toString().toDouble()
            showResult(value)
        }
    }

    private fun validateInformation(): Boolean {
        val validation: Boolean
        if (binding.alcoholTextInputEditText.text.toString().isNotBlank() &&
            binding.gasolineTextInputEditText.text.toString().isNotBlank()
        ) {
            validation = true
        } else {
            validation = false
            binding.resultAlcoholOrGasolineTextView.text = getString(R.string.empty_fields_text)
        }
        return validation
    }
}