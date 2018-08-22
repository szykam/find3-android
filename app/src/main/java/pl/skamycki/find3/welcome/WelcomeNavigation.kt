package pl.skamycki.find3.welcome

import pl.skamycki.find3.app.navigation.Navigator
import pl.skamycki.find3.main.MainActivity
import javax.inject.Inject

class WelcomeNavigation @Inject constructor(private val navigator: Navigator) {

    fun navigateToMain() = navigator.navigate(MainActivity::class.java, true)
}
