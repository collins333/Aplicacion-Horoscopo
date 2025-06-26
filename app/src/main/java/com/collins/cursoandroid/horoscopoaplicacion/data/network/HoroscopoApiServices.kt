package com.collins.cursoandroid.horoscopoaplicacion.data.network

import com.collins.cursoandroid.horoscopoaplicacion.data.network.response.RespuestaPrediccion
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopoApiServices {

    @GET("/{sign}")
    suspend fun getHoroscopo(@Path("sign") sign: String): RespuestaPrediccion
}