package com.example.wandy_p1_ap2.ui.dividir

import android.app.Application
import android.widget.Toast
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
    private val dividirRepository: DividirRepository,
    private val application: Application
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

    fun guardar() {
        if (Validation()) {
            return
        }

        val dividendo = Dividendo.toDoubleOrNull() ?: 0.0
        val divisor = Divisor.toDoubleOrNull() ?: 0.0
        val cociente = Cociente.toDoubleOrNull() ?: 0.0
        val residuo = Residuo.toDoubleOrNull() ?: 0.0

        if (dividendo == cociente * divisor + residuo) {
            val dividir = DividirEntity(
                Nombres = Nombres,
                Dividendo = dividendo,
                Divisor = divisor,
                Cociente = cociente,
                Residuo = residuo
            )
            viewModelScope.launch(Dispatchers.IO) {
                dividirRepository.save(dividir)
                Limpiar()
            }
            mostrarToast("Datos guardados exitosamente") // Mostrar un Toast
        } else {
           // Toast.makeText(context, "La igualdad Dividendo = Cociente * Divisor + Residuo no se cumple", Toast.LENGTH_SHORT).show()
            mostrarToast("No se cumple la divición") // Mostrar un Toast
        }
    }
    private fun mostrarToast(mensaje: String) {
        Toast.makeText(application, mensaje, Toast.LENGTH_SHORT).show()
    }

    fun eliminar(dividir: DividirEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            dividirRepository.delete(dividir)
            Limpiar()
        }
    }

    private fun Validation(): Boolean {
        var Validar = false

        nombresValidar = ""

        if (Nombres.isBlank()) {
            nombresValidar = "Ingrese un nombre"
            Validar = true
        }

        dividendoValidar = ""

        try {
            if (Dividendo.isBlank()) {
                dividendoValidar = "Ingrese un número entero"
                Validar = true
            } else {
                // Verificar si el dividendo es un número entero
                if (Dividendo.toIntOrNull() == null) {
                    dividendoValidar = "El dividendo no es un número entero válido"
                    Validar = true
                } else {
                    val dividendoValor = Dividendo.toInt()
                    val divisorValor = Divisor.toInt()
                    // Verificar si el dividendo es menor al divisor
                    if (dividendoValor < divisorValor) {
                        dividendoValidar = "El dividendo no debe ser menor al divisor"
                        Validar = true
                    }
                }
            }
        }catch (e: Exception){}

        divisorValidar = ""

        if (Divisor.isBlank()) {
            divisorValidar = "Ingrese un número entero"
            Validar = true
        } else {
            // Verificar si el divisor es un número entero
            if (Divisor.toIntOrNull() == null) {
                divisorValidar = "El divisor no es un número entero válido"
                Validar = true
            }
        }

        cocienteValidar = ""

        if (Cociente.isBlank()) {
            cocienteValidar = "Ingrese un número entero"
            Validar = true
        } else {
            // Verificar si el cociente es un número entero
            if (Cociente.toIntOrNull() == null) {
                cocienteValidar = "El cociente no es un número entero válido"
                Validar = true
            }
        }

        residuoValidar = ""

        if (Residuo.isBlank()) {
            residuoValidar = "Ingrese un número"
            Validar = true
        } else {
            // Verificar si el residuo es un número
            if (Residuo.toDoubleOrNull() == null) {
                residuoValidar = "El residuo no es un número válido"
                Validar = true
            }
        }

        return Validar
    }


    private fun Limpiar() {
        Nombres = ""
        Dividendo = ""
        Divisor = ""
        Cociente = ""
        Residuo = ""
    }
}