package com.devnunens.warp.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devnunens.warp.domain.dto.WeatherAlertDTO
import com.devnunens.warp.ui.components.ForecastItem

@Composable
fun WeatherAlertsListView(weatherList: List<WeatherAlertDTO>) {
    LazyColumn(modifier = Modifier.padding(bottom = 60.dp)) {
        itemsIndexed(items = weatherList) { _, item ->
            ForecastItem(weather = item)
        }
    }
}