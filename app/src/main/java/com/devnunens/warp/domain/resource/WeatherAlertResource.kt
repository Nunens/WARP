package com.devnunens.warp.domain.resource

sealed class WeatherAlertResource<T>(
    val data: T? = null,
    val message: String? = null
){
    class Success<T>(data: T?): WeatherAlertResource<T>(data)
    class Error<T>(message: String): WeatherAlertResource<T>(message = message)
    class Loading<T>(val isLoading: Boolean = true): WeatherAlertResource<T>()
}