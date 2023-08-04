package com.devnunens.warp.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devnunens.warp.domain.repository.WeatherAlertRepository
import com.devnunens.warp.domain.resource.WeatherAlertResource
import com.devnunens.warp.presentation.contract.PresentationContract
import com.devnunens.warp.presentation.state.StateManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor() : ViewModel(), PresentationContract.ViewModel {
    @Inject
    lateinit var repository: WeatherAlertRepository

    private val _state = mutableStateOf(StateManager())
    val state: State<StateManager> = _state

    override fun getWeatherAlert() {
        Log.e("WARP", "GET ALERTS VM")
        viewModelScope.async {
            repository
                .getWeather()
                .collect { resp ->
                    when (resp) {
                        is WeatherAlertResource.Loading -> {
                            _state.value = state.value.copy(
                                isLoading = resp.isLoading
                            )
                        }

                        is WeatherAlertResource.Success -> {
                            Log.e("WARP", "GET ALERTS RESPONSE: ${resp.data}")
                            resp.data?.let {
                                _state.value = state.value.copy(
                                    weatherAlertList = it
                                )
                            }
                        }

                        else -> {
                            Log.e("WARP", "GET ALERTS ERROR")
                            _state.value = state.value.copy(
                                error = resp.message.toString()
                            )
                        }
                    }
                }
        }
    }
}