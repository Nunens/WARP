package com.devnunens.warp.data.source.remote

import com.devnunens.warp.data.entity.Data
import retrofit2.http.GET

interface WeatherAlertApi {
    companion object {
        const val BASE_URL = "https://api.weather.gov/"
    }

    @GET("alerts/active?status=actual&message_type=alert")
    suspend fun getWeather(): Data
}