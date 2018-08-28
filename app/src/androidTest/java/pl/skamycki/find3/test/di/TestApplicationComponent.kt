package pl.skamycki.find3.test.di

import dagger.Component
import pl.skamycki.find3.app.di.ActivityModule
import pl.skamycki.find3.app.di.ApplicationModule
import pl.skamycki.find3.app.di.NetworkModule
import pl.skamycki.find3.app.di.ViewModelModule
import pl.skamycki.find3.data.Find3ServiceTest
import javax.inject.Singleton

@Component(modules = [
    ApplicationModule::class,
    ActivityModule::class,
    ViewModelModule::class,
    NetworkModule::class
])
@Singleton
interface TestApplicationComponent {

    fun inject(target: Find3ServiceTest)
}
