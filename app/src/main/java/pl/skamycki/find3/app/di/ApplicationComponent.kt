package pl.skamycki.find3.app.di

import dagger.Component
import pl.skamycki.find3.app.Find3Application
import javax.inject.Singleton

@Component(modules = [
    ApplicationModule::class,
    ActivityModule::class,
    ViewModelModule::class
])
@Singleton
interface ApplicationComponent {

    fun inject(app: Find3Application)
}
