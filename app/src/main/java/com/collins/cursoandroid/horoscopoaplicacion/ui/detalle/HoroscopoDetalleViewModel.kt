package com.collins.cursoandroid.horoscopoaplicacion.ui.detalle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.collins.cursoandroid.horoscopoaplicacion.domain.casoDeUso.GetPrediccionCasoUso
import com.collins.cursoandroid.horoscopoaplicacion.domain.model.HoroscopoModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HoroscopoDetalleViewModel @Inject constructor(private val getPrediccionCasoUso: GetPrediccionCasoUso): ViewModel() {

    private var _estado = MutableStateFlow<HoroscopoDetalleEstados>(HoroscopoDetalleEstados.Loading)
    val estado: StateFlow<HoroscopoDetalleEstados> = _estado

    lateinit var horoscopo: HoroscopoModel

    fun getHoroscopo(sign: HoroscopoModel) {

        horoscopo = sign

        viewModelScope.launch {
            _estado.value = HoroscopoDetalleEstados.Loading
            val resultado = withContext(Dispatchers.IO) { getPrediccionCasoUso(sign.name) } //hilo secundario
            if(resultado != null) {
                _estado.value = HoroscopoDetalleEstados.Success(resultado.horoscope, resultado.sign, horoscopo)
            } else {
                _estado.value = HoroscopoDetalleEstados.Error("Ha ocurrido un error")
            }

        }
    }
}