package com.collins.cursoandroid.horoscopoaplicacion.ui.detalle

sealed class HoroscopoDetalleEstados {
    data object Loading: HoroscopoDetalleEstados()
    data class Error(val error: String): HoroscopoDetalleEstados()
    data class Success(val prediccion: String, val sign: String): HoroscopoDetalleEstados()
}