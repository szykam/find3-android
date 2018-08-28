package pl.skamycki.find3.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ScanData(
        @Json(name = "wifi") val wifiNameToRssi: Map<String, Int>,
        @Json(name = "bluetooth") val bluetoothNameToRssi: Map<String, Int>
)
