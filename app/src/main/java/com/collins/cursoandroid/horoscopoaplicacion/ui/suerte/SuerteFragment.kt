package com.collins.cursoandroid.horoscopoaplicacion.ui.suerte

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.collins.cursoandroid.horoscopoaplicacion.R
import com.collins.cursoandroid.horoscopoaplicacion.databinding.FragmentSuerteBinding
import com.collins.cursoandroid.horoscopoaplicacion.ui.core.listeners.OnSwipeTouchListener
import com.collins.cursoandroid.horoscopoaplicacion.ui.modelo.SuerteModel
import com.collins.cursoandroid.horoscopoaplicacion.ui.proveedores.RandomCartaProvider
import dagger.hilt.android.AndroidEntryPoint
import java.util.Random
import javax.inject.Inject


@AndroidEntryPoint
class SuerteFragment : Fragment() {

    private var _binding: FragmentSuerteBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var randomCartaProvider: RandomCartaProvider

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniciarUI()
    }

    private fun iniciarUI() {
        prepararPrediccion()
        iniciarListeners()
    }

    private fun prepararPrediccion() {
        val currentSuerte = randomCartaProvider.obtenerSuerte()

        currentSuerte?.let {suerte: SuerteModel ->
            val currentPrediccion: String = getString(suerte.texto)
            val nombreCarta: String = getString(suerte.nombre)
            binding.tvNombre.text = nombreCarta
            binding.tvSuerte.text = currentPrediccion
            binding.ivAnverso.setImageResource(suerte.imagen)
            binding.tvCompartir.setOnClickListener { comparteResultado(currentPrediccion) }
        }
    }

    private fun comparteResultado(prediccion: String) {
        val enviarIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, prediccion)
            type = "text/plain"
        }

        val compartirIntent: Intent = Intent.createChooser(enviarIntent, null)
        startActivity(compartirIntent)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun iniciarListeners() {
    //    binding.ivRuleta.setOnClickListener { girarRuleta() }

        binding.ivRuleta.setOnTouchListener(object: OnSwipeTouchListener(requireContext()) {
            override fun onSwipeRight() {
                girarRuleta()
            }

            override fun onSwipeLeft() {
                girarRuleta()
            }
        })
    }

    private fun girarRuleta() {
        val random = Random()
        val grados = random.nextInt(1440) + 360

        val animacion = ObjectAnimator.ofFloat(binding.ivRuleta, View.ROTATION, 0f, grados.toFloat())
        animacion.duration = 2000
        animacion.interpolator = DecelerateInterpolator()
        animacion.doOnEnd { deslizarCarta() }
        animacion.start()
    }

    private fun deslizarCarta() {
        val deslizarArriba = AnimationUtils.loadAnimation(requireContext(), R.anim.deslizar_arriba)

        deslizarArriba.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
                binding.ivReverso.isVisible = true
            }

            override fun onAnimationEnd(animation: Animation?) {
                agrandarCarta()
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })
        binding.ivReverso.startAnimation(deslizarArriba)
    }

    private fun agrandarCarta() {
        val agrandarCarta = AnimationUtils.loadAnimation(requireContext(), R.anim.agrandar_carta)

        agrandarCarta.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                binding.ivReverso.isVisible = false
                mostrarPremonicion()
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })
        binding.ivReverso.startAnimation(agrandarCarta)
    }

    private fun mostrarPremonicion() {
        val desaparecerAnimacion = AlphaAnimation(1.0f, 0.0f)
        desaparecerAnimacion.duration = 200

        val aparecerAnimacion = AlphaAnimation(0.0f, 1.0f)
        aparecerAnimacion.duration = 1000

        desaparecerAnimacion.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                binding.clPreview.isVisible = false
                binding.clPrediccion.isVisible = true
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })

        binding.clPreview.startAnimation(desaparecerAnimacion)
        binding.clPrediccion.startAnimation(aparecerAnimacion)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuerteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}