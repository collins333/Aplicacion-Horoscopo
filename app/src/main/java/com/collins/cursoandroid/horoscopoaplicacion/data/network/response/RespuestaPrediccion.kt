package com.collins.cursoandroid.horoscopoaplicacion.data.network.response

import com.collins.cursoandroid.horoscopoaplicacion.domain.model.PrediccionModel
import com.google.gson.annotations.SerializedName

data class RespuestaPrediccion(
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("sign") val sign: String
){
    fun toDomain(): PrediccionModel {
        return PrediccionModel(
            horoscope = horoscope,
            sign = sign
        )
    }
}