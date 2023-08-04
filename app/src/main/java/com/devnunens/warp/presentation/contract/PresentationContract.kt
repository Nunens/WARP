package com.devnunens.warp.presentation.contract

import androidx.compose.runtime.Composable

interface PresentationContract {
    interface ViewComposable {
        @Composable
        fun showProgressView()

        @Composable
        fun showErrorView()

        @Composable
        fun showMainScreen()
    }

    interface ViewModel {
        fun getWeatherAlert()
    }
}