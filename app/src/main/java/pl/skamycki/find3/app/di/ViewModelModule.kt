package pl.skamycki.find3.app.di

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import pl.skamycki.find3.app.di.ViewModelFactory

@Module
interface ViewModelModule {

    @Binds
    fun model(model: ViewModelFactory): ViewModelProvider.Factory
}
