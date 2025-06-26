package com.collins.cursoandroid.horoscopoaplicacion.data.network

import com.collins.cursoandroid.horoscopoaplicacion.data.RepositorioImplementacion
import com.collins.cursoandroid.horoscopoaplicacion.domain.Repositorio
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun proveerRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://newastro.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun proveerHoroscopoApiServices(retrofit: Retrofit): HoroscopoApiServices {
        return retrofit.create(HoroscopoApiServices::class.java)
    }

    @Provides
    fun proveerRepositorio(apiServices: HoroscopoApiServices): Repositorio {
        return RepositorioImplementacion(apiServices)
    }
}