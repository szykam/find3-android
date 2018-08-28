package pl.skamycki.find3.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GpsData(
        @Json(name = "lat") val latitude: Double,
        @Json(name = "lon") val longitude: Double,
        @Json(name = "alt") val altitude: Double
)
