package com.collins.cursoandroid.horoscopoaplicacion.ui.proveedores

import com.collins.cursoandroid.horoscopoaplicacion.ui.modelo.SuerteModel
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

 class RandomCartaProviderTest {

   @Test
   fun `getRandomCarta debería retornar una carta random`() {
    val randomCarta = RandomCartaProvider()

    val carta: SuerteModel? = randomCarta.obtenerSuerte()

    assertNotNull(carta)
   }
 }