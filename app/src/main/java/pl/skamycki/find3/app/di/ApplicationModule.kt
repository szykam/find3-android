package pl.skamycki.find3.app.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val context: Context) {

    @Provides
    fun context() : Context = context
}
