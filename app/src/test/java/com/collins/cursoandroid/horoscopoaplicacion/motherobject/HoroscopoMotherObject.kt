package com.collins.cursoandroid.horoscopoaplicacion.motherobject

import com.collins.cursoandroid.horoscopoaplicacion.data.network.response.RespuestaPrediccion
import com.collins.cursoandroid.horoscopoaplicacion.domain.model.HoroscopoInfo

object HoroscopoMotherObject {
    val cualquierRespuesta = RespuestaPrediccion("date", "prediccion", "libra")

    val horoscopoInfoList = listOf(
        HoroscopoInfo.Aries,
        HoroscopoInfo.Taurus,
        HoroscopoInfo.Gemini,
        HoroscopoInfo.Cancer,
        HoroscopoInfo.Leo,
        HoroscopoInfo.Virgo,
        HoroscopoInfo.Libra,
        HoroscopoInfo.Scorpio,
        HoroscopoInfo.Sagittarius,
        HoroscopoInfo.Capricorn,
        HoroscopoInfo.Aquarius,
        HoroscopoInfo.Pisces
    )
}