package com.devnunens.warp.domain.dto

//event name "event", start date "effective", end date "ends", source "senderName" & duration (start date - end date)
data class WeatherAlertDTO(
    val startDate: String,
    val endDate: String,
    val name: String,
    val source: String,
    var duration: String,
    val imageUrl: String
)