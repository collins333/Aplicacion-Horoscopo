package com.collins.cursoandroid.horoscopoaplicacion.ui.horoscopo

import com.collins.cursoandroid.horoscopoaplicacion.data.proveedor.HoroscopoProvider
import com.collins.cursoandroid.horoscopoaplicacion.domain.model.HoroscopoInfo
import com.collins.cursoandroid.horoscopoaplicacion.motherobject.HoroscopoMotherObject.horoscopoInfoList
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertTrue

class HoroscopoViewModelTest {

    @MockK
    lateinit var horoscopoProvider: HoroscopoProvider

    private lateinit var viewModel: HoroscopoViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `cuando se crea el viewModel entonces los horoscopos se cargan`() {
        every { horoscopoProvider.generarHoroscopos() } returns horoscopoInfoList
        viewModel = HoroscopoViewModel(horoscopoProvider)

        val horoscopos: List<HoroscopoInfo> = viewModel.horoscopo.value

        assertTrue(horoscopos.isNotEmpty())
    }
}