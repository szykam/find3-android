package pl.skamycki.find3.main

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.skamycki.find3.learn.LearnFragment
import pl.skamycki.find3.settings.SettingsFragment
import pl.skamycki.find3.track.TrackFragment

@Module
interface MainActivityFragmentsModule {

    @ContributesAndroidInjector
    fun learnFragment(): LearnFragment

    @ContributesAndroidInjector
    fun trackFragment(): TrackFragment

    @ContributesAndroidInjector
    fun settingsFragment(): SettingsFragment
}
