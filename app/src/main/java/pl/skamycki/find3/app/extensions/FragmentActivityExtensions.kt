package pl.skamycki.find3.app.extensions

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(factory: ViewModelProvider.Factory = ViewModelProvider.NewInstanceFactory()): T {
    return ViewModelProviders.of(this, factory).get(T::class.java)
}
