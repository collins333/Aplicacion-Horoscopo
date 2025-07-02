package com.collins.cursoandroid.horoscopoaplicacion.data.core.interceptores

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(private val tokenManager: TokenManager): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val peticion = chain.request().newBuilder().header("Autorizacion", tokenManager.crearToken()).build()

        return chain.proceed(peticion)
    }
}

class TokenManager @Inject constructor() {
    fun crearToken(): String = "Token"
}