package pl.skamycki.find3.app.di

import android.content.Context
import dagger.Module
import dagger.Provides
import pl.skamycki.find3.app.infrastructure.AppExecutors
import pl.skamycki.find3.app.settings.AppSettings

@Module
class ApplicationModule(
        private val context: Context,
        private val appExecutors: AppExecutors? = null,
        private val appSettings: AppSettings? = null
) {

    @Provides
    fun context(): Context = context

    @Provides
    fun appExecutors() = appExecutors ?: AppExecutors()

    @Provides
    fun appSettings() = appSettings ?: AppSettings(context)
}
