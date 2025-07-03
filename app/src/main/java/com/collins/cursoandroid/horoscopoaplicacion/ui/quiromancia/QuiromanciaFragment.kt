package com.collins.cursoandroid.horoscopoaplicacion.ui.quiromancia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.collins.cursoandroid.horoscopoaplicacion.databinding.FragmentQuiromanciaBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuiromanciaFragment : Fragment() {

    private var _binding: FragmentQuiromanciaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuiromanciaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}