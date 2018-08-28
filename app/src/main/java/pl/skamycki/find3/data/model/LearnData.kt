package pl.skamycki.find3.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LearnData(
        @Json(name = "f") val family: String,
        @Json(name = "d") val device: String,
        @Json(name = "l") val location: String,
        @Json(name = "s") val scanData: ScanData,
        @Json(name = "gps") val gpsData: GpsData? = null
)
