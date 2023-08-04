package com.devnunens.warp.domain.repository

import com.devnunens.warp.domain.dto.WeatherAlertDTO
import com.devnunens.warp.domain.resource.WeatherAlertResource
import kotlinx.coroutines.flow.Flow

interface WeatherAlertRepository {
    suspend fun getWeather(): Flow<WeatherAlertResource<List<WeatherAlertDTO>>>

    fun calculateDuration(startDate: String, endDate: String): String
}