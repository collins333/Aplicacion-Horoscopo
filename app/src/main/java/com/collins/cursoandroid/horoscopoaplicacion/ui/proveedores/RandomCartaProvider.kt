package com.collins.cursoandroid.horoscopoaplicacion.ui.proveedores

import com.collins.cursoandroid.horoscopoaplicacion.R
import com.collins.cursoandroid.horoscopoaplicacion.ui.modelo.SuerteModel
import javax.inject.Inject
import kotlin.random.Random

class RandomCartaProvider @Inject constructor() {
    fun obtenerSuerte(): SuerteModel? {
        return when(Random.nextInt(0, 33)) {
            0 -> SuerteModel(R.drawable.card_fool, R.string.luck_0, R.string.fool)
            1 -> SuerteModel(R.drawable.card_moon, R.string.luck_1, R.string.moon)
            2 -> SuerteModel(R.drawable.card_hermit, R.string.luck_2, R.string.hermit)
            3 -> SuerteModel(R.drawable.card_star, R.string.luck_3, R.string.star)
            4 -> SuerteModel(R.drawable.card_sun, R.string.luck_4, R.string.sun)
            5 -> SuerteModel(R.drawable.card_sword, R.string.luck_5, R.string.sword)
            6 -> SuerteModel(R.drawable.card_chariot, R.string.luck_6, R.string.chariot)
            7 -> SuerteModel(R.drawable.card_death, R.string.luck_7, R.string.death)
            8 -> SuerteModel(R.drawable.card_devil, R.string.luck_8, R.string.devil)
            9 -> SuerteModel(R.drawable.card_empress, R.string.luck_9, R.string.empress)
            10 -> SuerteModel(R.drawable.card_hierophant, R.string.luck_10, R.string.hierophant)
            11 -> SuerteModel(R.drawable.card_ace_pentacles, R.string.luck_11, R.string.ace_pentacles)
            12 -> SuerteModel(R.drawable.card_judgement, R.string.luck_12, R.string.judgement)
            13 -> SuerteModel(R.drawable.card_world, R.string.luck_13, R.string.world)
            14 -> SuerteModel(R.drawable.card_wheel_fortune, R.string.luck_14, R.string.wheel_fortune)
            15 -> SuerteModel(R.drawable.card_tower, R.string.luck_15, R.string.tower)
            16 -> SuerteModel(R.drawable.card_temperance, R.string.luck_16, R.string.temperance)
            17 -> SuerteModel(R.drawable.card_strength, R.string.luck_17, R.string.strength)
            18 -> SuerteModel(R.drawable.card_queen_wands, R.string.luck_18, R.string.queen_wands)
            19 -> SuerteModel(R.drawable.card_queen_swords, R.string.luck_19, R.string.queen_swords)
            20 -> SuerteModel(R.drawable.card_priestess, R.string.luck_20, R.string.priestess)
            21 -> SuerteModel(R.drawable.card_nine_wands, R.string.luck_21, R.string.nine_wands)
            22 -> SuerteModel(R.drawable.card_page_wands, R.string.luck_22, R.string.page_wands)
            23 -> SuerteModel(R.drawable.card_magician, R.string.luck_23, R.string.magician)
            24 -> SuerteModel(R.drawable.card_king_pentacles, R.string.luck_24, R.string.king_pentacles)
            25 -> SuerteModel(R.drawable.card_two_pentacles, R.string.luck_25, R.string.two_pentacles)
            26 -> SuerteModel(R.drawable.card_queen_pentacles, R.string.luck_26, R.string.queen_pentacles)
            27 -> SuerteModel(R.drawable.card_justice, R.string.luck_27, R.string.justice)
            28 -> SuerteModel(R.drawable.card_king_swords, R.string.luck_28, R.string.king_swords)
            29 -> SuerteModel(R.drawable.card_king_wands, R.string.luck_29, R.string.king_wands)
            30 -> SuerteModel(R.drawable.card_king_cups, R.string.luck_30, R.string.king_cups)
            31 -> SuerteModel(R.drawable.card_queen_cup, R.string.luck_31, R.string.queen_cups)
            32 -> SuerteModel(R.drawable.card_lovers, R.string.luck_32, R.string.lovers)
            else -> null
        }
    }
}