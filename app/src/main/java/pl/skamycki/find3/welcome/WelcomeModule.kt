package pl.skamycki.find3.welcome

import android.support.v4.app.FragmentActivity
import dagger.Module
import dagger.Provides

@Module(includes = [
    WelcomeViewModelModule::class
])
class WelcomeModule {

    @Provides
    fun activity(activity: WelcomeActivity): FragmentActivity = activity
}
