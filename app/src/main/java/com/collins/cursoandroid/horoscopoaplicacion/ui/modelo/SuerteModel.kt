package com.collins.cursoandroid.horoscopoaplicacion.ui.modelo

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class SuerteModel(
    @DrawableRes val imagen: Int,
    @StringRes val texto: Int,
    @StringRes val nombre: Int
)