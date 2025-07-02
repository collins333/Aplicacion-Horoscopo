package com.collins.cursoandroid.horoscopoaplicacion.data.network

import com.collins.cursoandroid.horoscopoaplicacion.BuildConfig.BASE_URL
import com.collins.cursoandroid.horoscopoaplicacion.data.RepositorioImplementacion
import com.collins.cursoandroid.horoscopoaplicacion.data.core.interceptores.AuthInterceptor
import com.collins.cursoandroid.horoscopoaplicacion.domain.Repositorio
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun proveerRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun proveerOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {

        val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .addInterceptor(authInterceptor)
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