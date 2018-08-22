package pl.skamycki.find3.app.properties

import android.app.Activity
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ActivityBindingProperty<out T : ViewDataBinding>(@LayoutRes private val resId: Int) : ReadOnlyProperty<Activity, T> {

    private var binding: T? = null

    override operator fun getValue(thisRef: Activity, property: KProperty<*>): T = binding
            ?: createBinding(thisRef).also { binding = it }

    private fun createBinding(activity: Activity): T = DataBindingUtil.setContentView(activity, resId)
}
