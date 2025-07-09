package com.collins.cursoandroid.horoscopoaplicacion.ui.quiromancia

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker
import androidx.fragment.app.Fragment
import com.collins.cursoandroid.horoscopoaplicacion.databinding.FragmentQuiromanciaBinding
import com.google.common.util.concurrent.ListenableFuture
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuiromanciaFragment : Fragment() {

    companion object {
        private const val PERMISO_CAMARA = android.Manifest.permission.CAMERA
    }

    private var _binding: FragmentQuiromanciaBinding? = null
    private val binding get() = _binding!!

    private val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) {
        isGranted: Boolean ->

        if(isGranted) {
            startCamera()
        } else {
            Toast.makeText(requireContext(), "Acepta los permisos para poder usar la aplicación", Toast.LENGTH_LONG).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(comprobarPermisoCamara()) {
            startCamera()
        } else {
            requestPermissionLauncher.launch(PERMISO_CAMARA)
        }
    }

    private fun startCamera() {
        val proveedorCamara: ListenableFuture<ProcessCameraProvider> = ProcessCameraProvider.getInstance(requireContext())

        proveedorCamara.addListener({
            val camaraProveedor: ProcessCameraProvider = proveedorCamara.get()

            val previo: Preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(binding.pvBuscador.surfaceProvider)
                }

            val selectorCamara = CameraSelector.DEFAULT_BACK_CAMERA

            try {
                camaraProveedor.unbindAll()

                camaraProveedor.bindToLifecycle(this, selectorCamara, previo)
            } catch (e: Exception) {
                Log.i("prueba", "algo fue mal: ${e.message}")
            }

        }, ContextCompat.getMainExecutor(requireContext()))
    }

    private fun comprobarPermisoCamara(): Boolean {
        return PermissionChecker.checkSelfPermission(
            requireContext(), PERMISO_CAMARA
        ) == PermissionChecker.PERMISSION_GRANTED
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuiromanciaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}