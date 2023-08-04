package com.devnunens.warp.data.di

import com.devnunens.warp.data.repository.WeatherAlertRepositoryImplementation
import com.devnunens.warp.data.source.remote.WeatherAlertApi
import com.devnunens.warp.domain.repository.WeatherAlertRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WeatherAlertModule {

    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherAlertApi {
        return Retrofit.Builder()
            .baseUrl(WeatherAlertApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherAlertApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(api: WeatherAlertApi): WeatherAlertRepository {
        return WeatherAlertRepositoryImplementation(api)
    }
}