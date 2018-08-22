package pl.skamycki.find3.app.extensions

import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import pl.skamycki.find3.app.properties.ActivityBindingProperty

fun <T : ViewDataBinding> activityBinding(@LayoutRes resId: Int) = ActivityBindingProperty<T>(resId)
