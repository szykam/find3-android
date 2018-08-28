package pl.skamycki.find3.app.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import pl.skamycki.find3.app.settings.AppSettings
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*

@Module
class NetworkModule {

    @Provides
    fun retrofit(appSettings: AppSettings): Retrofit = appSettings.getServerUrl()?.let {
        Retrofit.Builder()
                .baseUrl(it)
                .client(okHttpClient())
                .addConverterFactory(MoshiConverterFactory.create(moshi()))
                .build()
    } ?: run {
        throw IllegalArgumentException("Server URL stored in AppSettings is null.")
    }

    private fun okHttpClient() = OkHttpClient.Builder()
            .apply {
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.level = BODY
                addInterceptor(loggingInterceptor)
            }
            .build()


    private fun moshi() = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .add(Date::class.java, Rfc3339DateJsonAdapter())
            .build()
}
