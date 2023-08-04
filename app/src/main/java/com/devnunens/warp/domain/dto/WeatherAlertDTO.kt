package com.devnunens.warp.domain.dto

data class WeatherAlertDTO(
    val startDate: String,
    val endDate: String,
    val name: String,
    val source: String,
    var duration: String,
    val imageUrl: String
)