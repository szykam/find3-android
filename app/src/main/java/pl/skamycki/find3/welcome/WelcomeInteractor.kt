package pl.skamycki.find3.welcome

import pl.skamycki.find3.app.settings.AppSettings
import javax.inject.Inject

class WelcomeInteractor @Inject constructor(
        private val settings: AppSettings
) {
    fun saveSettings(
            family: String,
            device: String,
            url: String
    ) = settings.apply {
        setFamily(family)
        setDevice(device)
        setServerUrl(url)
    }
}
