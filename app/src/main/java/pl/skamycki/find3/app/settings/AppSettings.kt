package pl.skamycki.find3.app.settings

import android.content.Context
import javax.inject.Inject

class AppSettings @Inject constructor(context: Context) {

    private val prefs = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

    fun getFamily() : String? = prefs.getString(KEY_FAMILY, null)

    fun setFamily(family: String) = prefs.edit().putString(KEY_FAMILY, family).apply()

    fun getDevice() : String? = prefs.getString(KEY_DEVICE, null)

    fun setDevice(device: String) = prefs.edit().putString(KEY_DEVICE, device).apply()

    fun getLocation() : String? = prefs.getString(KEY_LOCATION, null)

    fun setLocation(location: String) = prefs.edit().putString(KEY_LOCATION, location).apply()

    fun getServerUrl() : String? = prefs.getString(KEY_SERVER_URL, null)

    fun setServerUrl(url: String) = prefs.edit().putString(KEY_SERVER_URL, url).apply()

    companion object {
        const val PREFERENCES_NAME = "AppSettings.PREFERENCES_NAME"
        const val KEY_FAMILY = "AppSettings.KEY_FAMILY"
        const val KEY_DEVICE = "AppSettings.KEY_DEVICE"
        const val KEY_LOCATION = "AppSettings.KEY_LOCATION"
        const val KEY_SERVER_URL = "AppSettings.KEY_SERVER_URL"
    }
}
