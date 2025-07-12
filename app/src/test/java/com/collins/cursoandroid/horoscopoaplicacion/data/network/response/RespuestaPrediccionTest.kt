package com.collins.cursoandroid.horoscopoaplicacion.data.network.response

import com.collins.cursoandroid.horoscopoaplicacion.domain.model.PrediccionModel
import com.collins.cursoandroid.horoscopoaplicacion.motherobject.HoroscopoMotherObject.cualquierRespuesta
import io.kotlintest.shouldBe
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class RespuestaPrediccionTest {

  @Test
  fun `toDomain deberia retornar un correcto PrediccionModel`() {
    //given
     val horoscopoRespuesta = cualquierRespuesta
   //when
    val prediccionModelo: PrediccionModel = horoscopoRespuesta.toDomain()
   //then
    prediccionModelo.sign shouldBe  horoscopoRespuesta.sign
    prediccionModelo.horoscope shouldBe  horoscopoRespuesta.horoscope
  }
 }