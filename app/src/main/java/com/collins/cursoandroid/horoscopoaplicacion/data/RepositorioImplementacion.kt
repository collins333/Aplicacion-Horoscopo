package com.collins.cursoandroid.horoscopoaplicacion.data

import android.util.Log
import com.collins.cursoandroid.horoscopoaplicacion.data.network.HoroscopoApiServices
import com.collins.cursoandroid.horoscopoaplicacion.domain.Repositorio
import com.collins.cursoandroid.horoscopoaplicacion.domain.model.PrediccionModel
import javax.inject.Inject

class RepositorioImplementacion @Inject constructor(private val apiService: HoroscopoApiServices): Repositorio {
    override suspend fun getPrediccion(sign: String): PrediccionModel? {
        kotlin.runCatching { apiService.getHoroscopo(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("algo", "Ha ocurrido un error, ${it.message}") }

        return null
    }
}