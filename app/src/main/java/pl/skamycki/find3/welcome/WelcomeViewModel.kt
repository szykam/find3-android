package pl.skamycki.find3.welcome

import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.ViewModel
import android.util.Patterns
import pl.skamycki.find3.app.extensions.addValueSource
import pl.skamycki.find3.app.extensions.emptyString
import pl.skamycki.find3.app.extensions.mutableLiveDataOf
import java.util.regex.Pattern
import javax.inject.Inject

class WelcomeViewModel @Inject constructor() : ViewModel() {

    val family = mutableLiveDataOf(emptyString())

    val device = mutableLiveDataOf(emptyString())

    val server = mutableLiveDataOf(emptyString())

    val continueButtonEnabled = MediatorLiveData<Boolean>()
            .addValueSource(family) { validate(family.value!!, device.value!!, server.value!!) }
            .addValueSource(device) { validate(family.value!!, device.value!!, server.value!!) }
            .addValueSource(server) { validate(family.value!!, device.value!!, server.value!!) }

    private fun validate(family: String, device: String, server: String) =
            family.isNotEmpty() && device.isNotEmpty() && Patterns.WEB_URL.matcher(server).matches()
}
