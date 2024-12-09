package com.example.canastas

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var contadorNosotros by mutableStateOf(0)
    var contadorEllos by mutableStateOf(0)
}