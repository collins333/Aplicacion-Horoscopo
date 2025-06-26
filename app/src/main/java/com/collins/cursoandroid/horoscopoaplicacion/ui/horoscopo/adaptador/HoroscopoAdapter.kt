package com.collins.cursoandroid.horoscopoaplicacion.ui.horoscopo.adaptador

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.collins.cursoandroid.horoscopoaplicacion.R
import com.collins.cursoandroid.horoscopoaplicacion.domain.model.HoroscopoInfo

class HoroscopoAdapter(private var horoscopoList: List<HoroscopoInfo> = emptyList(), private val onItemSelected: (HoroscopoInfo) -> Unit): RecyclerView.Adapter<HoroscopoViewHolder>() {

    fun actualizarLista(lista: List<HoroscopoInfo>) {
        horoscopoList = lista
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopoViewHolder {
        return HoroscopoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscopo , parent, false)
        )
    }

    override fun getItemCount() = horoscopoList.size

    override fun onBindViewHolder(holder: HoroscopoViewHolder, position: Int) {
        holder.render(horoscopoList[position], onItemSelected)
    }
}