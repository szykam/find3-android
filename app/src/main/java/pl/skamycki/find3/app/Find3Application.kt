package pl.skamycki.find3.app

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import pl.skamycki.find3.app.di.ApplicationModule
import pl.skamycki.find3.app.di.DaggerApplicationComponent
import javax.inject.Inject

open class Find3Application : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    protected open fun initializeDagger() = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
            .inject(this)


}
