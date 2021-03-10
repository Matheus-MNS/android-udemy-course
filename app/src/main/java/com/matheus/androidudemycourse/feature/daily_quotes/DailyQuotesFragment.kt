package com.matheus.androidudemycourse.feature.daily_quotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.FragmentDailyQuotesBinding
import java.util.*
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt


class DailyQuotesFragment : Fragment() {

    private lateinit var binding: FragmentDailyQuotesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDailyQuotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.newQuotesButton.setOnClickListener {
            sortQuotes(quotes)
        }
    }

    val quotes: Array<String> = arrayOf(
        "Você é o único motivo do seu fracasso.",
        "Desista, ainda da tempo de não passar vergonha!!",
        "Desista no primeiro obstáculo!",
        "Hoje foi ruim, amanhã será péssimo!!",
        "Agora parece que piorou"
    )

    fun sortQuotes(agrs: Array<String>) {
        val i = Random.nextInt(0, 4)
        binding.quotesTextView.text = quotes[i]
    }
}