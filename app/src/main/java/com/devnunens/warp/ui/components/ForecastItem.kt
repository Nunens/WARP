package com.devnunens.warp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Arrangement.Top
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.devnunens.warp.R
import com.devnunens.warp.domain.dto.WeatherAlertDTO

@Composable
fun ForecastItem(weather: WeatherAlertDTO) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .wrapContentHeight(), shape = RoundedCornerShape(8.dp), elevation = 4.dp
    ) {
        Surface() {
            Row(verticalAlignment = Alignment.CenterVertically) {
                /*Image(
                    painter = painterResource(id = R.drawable.forest_cloudy),
                    contentDescription = "",
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .padding(4.dp),
                    contentScale = ContentScale.Fit
                )*/
                AsyncImage(
                    model = weather.imageUrl,
                    contentDescription = "",
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .padding(4.dp),
                    contentScale = ContentScale.Fit
                )
                Column(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "EVENT: ${weather.name}",
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier
                            .padding(4.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "SENDER: ${weather.source}",
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier
                            .padding(4.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "FROM: ${weather.startDate}",
                        style = MaterialTheme.typography.subtitle2,
                        modifier = Modifier
                            .padding(4.dp)
                    )
                    Text(
                        text = "TO: ${weather.endDate}",
                        style = MaterialTheme.typography.subtitle2,
                        modifier = Modifier
                            .padding(4.dp)
                    )
                    Text(
                        text = "DURATION: ${weather.duration} DAY(s)",
                        style = MaterialTheme.typography.subtitle2,
                        modifier = Modifier
                            .padding(4.dp)
                    )
                }
            }
        }
    }
}