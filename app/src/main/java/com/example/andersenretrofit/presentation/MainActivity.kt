package com.example.andersenretrofit.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.andersenretrofit.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        val viewModel: MainActivityViewModel by viewModels()

        binding!!.getCurrencyButton.setOnClickListener {
            val name = binding!!.inputCurrency.editText?.text.toString()
            viewModel.getCurrencyByName(name)
        }

        viewModel.uiState.observe(this) { uiState ->
            when (uiState) {
                is MainActivityViewModel.UiState.Empty -> binding!!.textView.text = ""
                is MainActivityViewModel.UiState.Result -> binding!!.textView.text = uiState.title
            }
        }
    }
}
