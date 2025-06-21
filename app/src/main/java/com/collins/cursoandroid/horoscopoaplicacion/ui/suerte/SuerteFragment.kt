package com.collins.cursoandroid.horoscopoaplicacion.ui.suerte

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.collins.cursoandroid.horoscopoaplicacion.databinding.FragmentSuerteBinding

class SuerteFragment : Fragment() {

    private var _binding: FragmentSuerteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuerteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}