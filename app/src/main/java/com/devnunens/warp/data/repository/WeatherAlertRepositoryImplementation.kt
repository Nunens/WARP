package com.devnunens.warp.data.repository

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.devnunens.warp.data.entity.Data
import com.devnunens.warp.data.source.remote.WeatherAlertApi
import com.devnunens.warp.domain.dto.WeatherAlertDTO
import com.devnunens.warp.domain.repository.WeatherAlertRepository
import com.devnunens.warp.domain.resource.WeatherAlertResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.Date
import java.util.Locale
import javax.inject.Inject
import kotlin.math.ceil

class WeatherAlertRepositoryImplementation @Inject constructor(private val api: WeatherAlertApi) :
    WeatherAlertRepository {

    private val url: String = "https://picsum.photos/"
    private val tag: String? = WeatherAlertRepositoryImplementation::class.simpleName
    private val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeather(): Flow<WeatherAlertResource<List<WeatherAlertDTO>>> {
        return flow {
            try {
                emit(WeatherAlertResource.Loading(isLoading = true))
                val resp: Data = api.getWeather()
                val data: List<WeatherAlertDTO> = resp.features.map {
                    //Added the below if statement to solve the end date null issues
                    if (it.properties!!.ends == null) {
                        //Default end date if its null
                        it.properties!!.ends = "2023-08-04T19:00:00-05:00"
                    }
                    WeatherAlertDTO(
                        it.properties!!.effective!!,
                        it.properties!!.ends!!,
                        it.properties!!.event!!,
                        it.properties!!.senderName!!,
                        // I can also do the below when setting my list items
                        calculateDuration(it.properties!!.effective!!, it.properties!!.ends!!),
                        "$url${(1..1000).random()}",
                    )
                }
                emit(WeatherAlertResource.Success(data = data))
                emit(WeatherAlertResource.Loading(isLoading = false))
            } catch (e: HttpException) {
                Log.e(tag, "HTTP EXCEPTION", e)
                emit(WeatherAlertResource.Loading(isLoading = false))
                emit(WeatherAlertResource.Error(message = "${e.message}"))
            } catch (e: IOException) {
                Log.e(tag, "IO EXCEPTION", e)
                emit(WeatherAlertResource.Loading(isLoading = false))
                emit(WeatherAlertResource.Error(message = "${e.message}"))
            } catch (e: Exception) {
                Log.e(tag, "EXCEPTION", e)
                emit(WeatherAlertResource.Loading(isLoading = false))
                emit(WeatherAlertResource.Error(message = "${e.message}"))
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun calculateDuration(startDate: String, endDate: String): String {
        return ceil(
            (((
                    Instant.ofEpochSecond(
                        formatter.parse(endDate).time.minus(
                            formatter.parse(startDate).time
                        )
                    ).epochSecond.div(1000.0)) / 60) / 60) / 24
        ).toInt().toString()
    }
}