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
    lateinit var priceAlcohol: String
    lateinit var priceGasoline: String

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

        priceAlcohol = binding.alcoholTextInputEditText.text.toString()
        priceGasoline = binding.gasolineTextInputEditText.text.toString()

        setupClick()
    }

    private fun setupClick() {
        binding.calculatorButtom.setOnClickListener {
            fuelPriceCalculator()
        }
    }

    private fun fuelPriceCalculator() {

        val validate = validateInformation(priceAlcohol, priceGasoline)
        if (validate) {
            val aux = priceAlcohol.toDouble() / priceGasoline.toDouble()
            if (aux >= 0.7) {
                binding.resultAlcoholOrGasolineTextView.text =
                    getString(R.string.gasoline_better_text)
            } else {
                binding.resultAlcoholOrGasolineTextView.text =
                    getString(R.string.alcohol_better_text)
            }
        } else {
            binding.resultAlcoholOrGasolineTextView.text = getString(R.string.empty_fields_text)
        }
    }

    private fun validateInformation(pAlcohol: String?, pGasoline: String?): Boolean {

        var validate = true
        if (pAlcohol.isNullOrBlank()) {
            validate = false
        } else if (pGasoline.isNullOrBlank()) {
            validate = false
        }
        return validate
    }
}