package pl.skamycki.find3.app.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.skamycki.find3.main.MainModule
import pl.skamycki.find3.main.MainActivity
import pl.skamycki.find3.welcome.WelcomeActivity
import pl.skamycki.find3.welcome.WelcomeModule

@Module
interface ActivityModule {

    @ContributesAndroidInjector(modules = [WelcomeModule::class])
    fun welcomeActivity(): WelcomeActivity

    @ContributesAndroidInjector(modules = [MainModule::class])
    fun mainActivity(): MainActivity
}
