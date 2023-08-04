package com.devnunens.warp.ui.window

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.devnunens.warp.presentation.contract.PresentationContract
import com.devnunens.warp.presentation.viewmodel.WeatherViewModel
import com.devnunens.warp.ui.screen.ErrorView
import com.devnunens.warp.ui.screen.WeatherAlertsListView
import com.devnunens.warp.ui.screen.ProgressView
import com.devnunens.warp.ui.theme.WeatherTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivityCompose : ComponentActivity(), PresentationContract.ViewComposable {
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getWeatherAlert()
        setContent {
            WeatherTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    if (viewModel.state.value.isLoading) {
                        showProgressView()
                    } else if (viewModel.state.value.error.isNotEmpty()) {
                        showErrorView()
                    } else {
                        showMainScreen()
                    }
                }
            }
        }
    }

    @Composable
    override fun showProgressView() {
        ProgressView()
    }

    @Composable
    override fun showErrorView() {
        ErrorView(error = viewModel.state.value.error)
    }

    @Composable
    override fun showMainScreen() {
        WeatherAlertsListView(viewModel.state.value.weatherAlertList)
    }
}