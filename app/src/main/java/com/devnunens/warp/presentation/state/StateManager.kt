package com.devnunens.warp.presentation.state

import com.devnunens.warp.domain.dto.WeatherAlertDTO

data class StateManager(
    val weatherAlertList: List<WeatherAlertDTO> = emptyList(),
    val error: String = "",
    val randomNumber: Int = 0,
    val isLoading: Boolean = false,
)