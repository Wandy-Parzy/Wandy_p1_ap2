package com.example.wandy_p1_ap2.ui.dividir

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wandy_p1_ap2.data.local.entity.DividirEntity
import com.example.wandy_p1_ap2.data.repository.DividirRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DividirUiState(
    val dividirList: List<DividirEntity> = emptyList()
)

@HiltViewModel
class DividirViewModel @Inject constructor(
    private val dividirRepository: DividirRepository
) : ViewModel() {
    var Nombres by mutableStateOf("")
    var Dividendo by mutableStateOf("")
    var Divisor by mutableStateOf("")
    var Cociente by mutableStateOf("")
    var Residuo by mutableStateOf("")

    var nombresValidar by mutableStateOf("")
    var dividendoValidar by mutableStateOf("")
    var divisorValidar by mutableStateOf("")
    var cocienteValidar by mutableStateOf("")
    var residuoValidar by mutableStateOf("")


    var uiState = MutableStateFlow(DividirUiState())
        private set

    init {
        getListDividir()
    }

    fun getListDividir() {
        viewModelScope.launch(Dispatchers.IO) {
            dividirRepository.getAll().collect { lista ->
                uiState.update {
                    it.copy(dividirList = lista)
                }
            }
        }
    }

    fun nombresChanged(nombres: String) {
        this.Nombres = nombres
        Validation()
    }

    fun dividendoChanged(Dividendo: String) {
        this.Dividendo = Dividendo
        Validation()
    }

    fun divisorChanged(Divisor: String) {
        this.Divisor = Divisor
        Validation()
    }

    fun cocienteChanged(Cociente: String) {
        this.Cociente = Cociente
        Validation()
    }

    fun residuoChanged(Residuo: String) {
        this.Residuo = Residuo
        Validation()
    }
/*
    fun guardar() {
        if (Validation())
            return

        val dividir = DividirEntity(
            Nombres = Nombres,
            Dividendo = Dividendo.toDoubleOrNull() ?: 0.0,
            Divisor = Divisor.toDoubleOrNull() ?: 0.0,
            Cociente = Cociente.toDoubleOrNull() ?: 0.0,
            Residuo = Residuo.toDoubleOrNull() ?: 0.0
        )

        viewModelScope.launch(Dispatchers.IO) {
            dividirRepository.save(dividir)
           // Limpiar()
        }
    }*/

    private fun Validation(): Boolean {

        var Validar = false

        nombresValidar = ""

        if (Nombres.isBlank()) {
            nombresValidar = "Ingrese un nombre"
            Validar = true
        } else {
            Validar
        }

        dividendoValidar = ""

        if (Dividendo.isBlank()) {
            divisorValidar = "Ingrese un numero entero"
            Validar = true
        } else {
            Validar
        }

        divisorValidar = ""

        if ((Divisor.toDoubleOrNull() ?: 0.0) <= 0.0) {
            divisorValidar = "Ingrese un numero entero"
            Validar = true
        } else {
            Validar
        }

        cocienteValidar = ""

        if ((Cociente.toDoubleOrNull() ?: 0.0) <= 0.0) {
            cocienteValidar = "Ingrese un numero entero"
            Validar = true
        } else {
            Validar
        }

        residuoValidar = ""

        if ((Residuo.toDoubleOrNull() ?: 0.0) <= 0.0) {
            residuoValidar = "Ingrese un numero "
            Validar = true
        } else {
            Validar
        }

        return Validar
    }


}