package com.collins.cursoandroid.horoscopoaplicacion.ui.horoscopo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.collins.cursoandroid.horoscopoaplicacion.databinding.FragmentHoroscopoBinding
import com.collins.cursoandroid.horoscopoaplicacion.domain.model.HoroscopoInfo.Aquarius
import com.collins.cursoandroid.horoscopoaplicacion.domain.model.HoroscopoInfo.Aries
import com.collins.cursoandroid.horoscopoaplicacion.domain.model.HoroscopoInfo.Cancer
import com.collins.cursoandroid.horoscopoaplicacion.domain.model.HoroscopoInfo.Capricorn
import com.collins.cursoandroid.horoscopoaplicacion.domain.model.HoroscopoInfo.Gemini
import com.collins.cursoandroid.horoscopoaplicacion.domain.model.HoroscopoInfo.Leo
import com.collins.cursoandroid.horoscopoaplicacion.domain.model.HoroscopoInfo.Libra
import com.collins.cursoandroid.horoscopoaplicacion.domain.model.HoroscopoInfo.Pisces
import com.collins.cursoandroid.horoscopoaplicacion.domain.model.HoroscopoInfo.Sagittarius
import com.collins.cursoandroid.horoscopoaplicacion.domain.model.HoroscopoInfo.Scorpio
import com.collins.cursoandroid.horoscopoaplicacion.domain.model.HoroscopoInfo.Taurus
import com.collins.cursoandroid.horoscopoaplicacion.domain.model.HoroscopoInfo.Virgo
import com.collins.cursoandroid.horoscopoaplicacion.domain.model.HoroscopoModel
import com.collins.cursoandroid.horoscopoaplicacion.ui.horoscopo.adaptador.HoroscopoAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopoFragment : Fragment() {

    private val horoscopoViewModel by viewModels<HoroscopoViewModel>()
    private lateinit var adaptador: HoroscopoAdapter

    private var _binding: FragmentHoroscopoBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniciarUI()
    }

    private fun iniciarUI() {
        iniciarEstadoUI()
        iniciarLista()
    }

    private fun iniciarLista() {

        adaptador = HoroscopoAdapter(onItemSelected = {

            val type = when(it) {
                Aries -> HoroscopoModel.Aries
                Taurus -> HoroscopoModel.Taurus
                Gemini -> HoroscopoModel.Gemini
                Cancer -> HoroscopoModel.Cancer
                Leo -> HoroscopoModel.Leo
                Virgo -> HoroscopoModel.Virgo
                Libra -> HoroscopoModel.Libra
                Scorpio -> HoroscopoModel.Scorpio
                Sagittarius -> HoroscopoModel.Sagittarius
                Capricorn -> HoroscopoModel.Capricorn
                Aquarius -> HoroscopoModel.Aquarius
                Pisces -> HoroscopoModel.Pisces
            }

//            Toast.makeText(context, getString(it.nombre), Toast.LENGTH_LONG).show()
            findNavController().navigate(
                HoroscopoFragmentDirections.actionHoroscopoFragmentToHoroscopoDetalleActivity(type)
            )
        })

        binding.rvHoroscopo.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = adaptador
        }
    }

    private fun iniciarEstadoUI() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopoViewModel.horoscopo.collect {
                    adaptador.actualizarLista(it)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHoroscopoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}