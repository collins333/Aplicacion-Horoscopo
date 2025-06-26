package com.collins.cursoandroid.horoscopoaplicacion.ui.detalle

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.collins.cursoandroid.horoscopoaplicacion.R
import com.collins.cursoandroid.horoscopoaplicacion.databinding.ActivityHoroscopoDetalleBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopoDetalleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopoDetalleBinding
    private val horoscopoDetalleViewModel: HoroscopoDetalleViewModel by viewModels()

    private val args: HoroscopoDetalleActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHoroscopoDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        iniciarUi()
        horoscopoDetalleViewModel.getHoroscopo(args.type.name)
    }

    private fun iniciarUi() {
        iniciarUIEstado()
    }

    private fun iniciarUIEstado() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopoDetalleViewModel.estado.collect {
                    when(it) {
                        HoroscopoDetalleEstados.Loading -> loadingEstado()
                        is HoroscopoDetalleEstados.Error -> errorEstado()
                        is HoroscopoDetalleEstados.Success -> successEstado(it)
                    }
                }
            }
        }
    }

    private fun loadingEstado() {
        binding.pb.isVisible = true
    }

    private fun errorEstado() {
        binding.pb.isVisible = false
    }

    private fun successEstado(estados: HoroscopoDetalleEstados.Success) {
        binding.pb.isVisible = false
        binding.tvTitulo.text = estados.sign
        binding.tvCuerpo.text = estados.prediccion
    }
}