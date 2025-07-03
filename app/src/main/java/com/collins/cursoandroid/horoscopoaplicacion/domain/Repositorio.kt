package com.collins.cursoandroid.horoscopoaplicacion.domain

import com.collins.cursoandroid.horoscopoaplicacion.domain.model.PrediccionModel

interface Repositorio {
    suspend fun getPrediccion(sign: String): PrediccionModel?
}