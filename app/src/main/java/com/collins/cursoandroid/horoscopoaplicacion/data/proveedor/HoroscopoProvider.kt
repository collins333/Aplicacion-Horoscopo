package com.collins.cursoandroid.horoscopoaplicacion.data.proveedor

import com.collins.cursoandroid.horoscopoaplicacion.domain.model.HoroscopoInfo
import com.collins.cursoandroid.horoscopoaplicacion.domain.model.HoroscopoInfo.*
import javax.inject.Inject

class HoroscopoProvider @Inject constructor() {
    fun generarHoroscopos(): List<HoroscopoInfo> {
        return listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}