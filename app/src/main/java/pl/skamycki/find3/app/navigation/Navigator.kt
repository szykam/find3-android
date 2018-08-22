package pl.skamycki.find3.app.navigation

import android.app.Activity
import android.content.Intent
import android.support.v4.app.FragmentActivity
import javax.inject.Inject

class Navigator @Inject constructor(private val activity: FragmentActivity) {

    fun navigate(command: Command) = command.navigate(activity)

    fun navigate(kls: Class<out Activity>, finish: Boolean = false) {
        activity.startActivity(Intent(activity, kls))
        if (finish) activity.finish()
    }

    interface Command {
        fun navigate(activity: FragmentActivity)
    }
}
