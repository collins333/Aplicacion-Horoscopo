package com.collins.cursoandroid.horoscopoaplicacion.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.collins.cursoandroid.horoscopoaplicacion.R
import com.collins.cursoandroid.horoscopoaplicacion.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        iniciarUI()
    }

    private fun iniciarUI() {
        iniciarNavegacion()
    }

    private fun iniciarNavegacion() {
        val navHost: NavHostFragment = supportFragmentManager.findFragmentById(R.id.fcvMain) as NavHostFragment
        navController = navHost.navController
        binding.bnvMain.setupWithNavController(navController)
    }
}