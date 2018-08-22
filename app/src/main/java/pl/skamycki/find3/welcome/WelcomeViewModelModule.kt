package pl.skamycki.find3.welcome

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import pl.skamycki.find3.app.di.ViewModelKey

@Module
interface WelcomeViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(WelcomeViewModel::class)
    fun viewModel(viewModel: WelcomeViewModel): ViewModel
}
