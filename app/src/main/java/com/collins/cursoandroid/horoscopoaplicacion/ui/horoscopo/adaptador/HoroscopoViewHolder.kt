package com.collins.cursoandroid.horoscopoaplicacion.ui.horoscopo.adaptador

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.collins.cursoandroid.horoscopoaplicacion.databinding.ItemHoroscopoBinding
import com.collins.cursoandroid.horoscopoaplicacion.domain.model.HoroscopoInfo

class HoroscopoViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopoBinding.bind(view)

    fun render(horoscopoInfo: HoroscopoInfo, onItemSelected: (HoroscopoInfo) -> Unit) {

        val context = binding.tvHoroscopo.context

        binding.ivHoroscopo.setImageResource(horoscopoInfo.img)
        binding.tvHoroscopo.text = context.getString(horoscopoInfo.nombre)

        binding.clHoroscopo.setOnClickListener {
            rotarImagen(binding.ivHoroscopo, nuevaLambda = { onItemSelected(horoscopoInfo) })
        }

    }

    private fun rotarImagen(view: View, nuevaLambda: () -> Unit) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360F)
            withEndAction { nuevaLambda() }
            start()
        }
    }
}