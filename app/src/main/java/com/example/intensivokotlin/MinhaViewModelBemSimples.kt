package com.example.intensivokotlin

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MinhaViewModelBemSimples: ViewModel() {
    //private val _contadorDaViewModel: MutableStateFlow<Int> = MutableStateFlow(0)

    private val _contadorDaViewModel = MutableStateFlow(0)
    val contadorDaViewPublico: StateFlow<Int> get() = _contadorDaViewModel

    fun incrementaContador(){
        _contadorDaViewModel.value = _contadorDaViewModel.value + 1
    }

    fun desincrementaContador(){
        _contadorDaViewModel.value = _contadorDaViewModel.value - 1
    }
}
