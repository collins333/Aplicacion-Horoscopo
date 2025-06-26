package com.collins.cursoandroid.horoscopoaplicacion.domain.casoDeUso

import com.collins.cursoandroid.horoscopoaplicacion.domain.Repositorio
import javax.inject.Inject

class GetPrediccionCasoUso @Inject constructor(private val repositorio: Repositorio) {
    suspend operator fun invoke(sign: String) = repositorio.getPrediccion(sign)
}