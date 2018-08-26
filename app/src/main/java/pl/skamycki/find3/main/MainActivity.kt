package pl.skamycki.find3.main

import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import pl.skamycki.find3.R
import pl.skamycki.find3.app.activity.BaseFragmentInjectorActivity

class MainActivity : BaseFragmentInjectorActivity() {

    override val layoutResId: Int
        get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navController = Navigation.findNavController(this, R.id.mainNavFragment)
        bottom_nav_view.setupWithNavController(navController)
    }
}
