package com.example.andersenretrofit.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.andersenretrofit.data.GetCurrencyRepositoryImpl
import com.example.andersenretrofit.domain.GetCurrencyByNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getCurrencyByNameUseCase: GetCurrencyByNameUseCase
):ViewModel() {
    private val _uiState = MutableLiveData<UiState>(UiState.Empty)
    val uiState: LiveData<UiState> = _uiState

    fun getCurrencyByName(name:String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = getCurrencyByNameUseCase.getCurrencyByName(name)
            val currency = response.body()?.data
            _uiState.postValue(UiState.Result("${currency?.id}\n${currency?.rateUsd}"))
        }
    }

    sealed class UiState {
        data object Empty:UiState()
        class Result(val title:String):UiState()
    }
}
