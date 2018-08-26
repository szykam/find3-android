package pl.skamycki.find3.welcome

import android.view.inputmethod.EditorInfo
import pl.skamycki.find3.app.settings.AppSettings
import javax.inject.Inject

class WelcomeInteractor @Inject constructor(
        private val settings: AppSettings,
        private val navigation: WelcomeNavigation
) {
    fun onSaveClicked(
            family: String,
            device: String,
            url: String
    ) = handleSave(
            family,
            device,
            url
    )

    fun onKeyboardAction(actionId: Int,
                         family: String,
                         device: String,
                         url: String) = when (actionId) {
        EditorInfo.IME_ACTION_DONE, EditorInfo.IME_ACTION_NEXT -> {
            handleSave(family, device, url)
            true
        }
        else -> false
    }

    private fun handleSave(
            family: String,
            device: String,
            url: String
    ) {
        settings.apply {
            setFamily(family)
            setDevice(device)
            setServerUrl(url)
        }
        navigation.navigateToMain()
    }
}
