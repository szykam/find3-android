package pl.skamycki.find3.data

import kotlinx.coroutines.experimental.withContext
import pl.skamycki.find3.app.infrastructure.AppExecutors
import pl.skamycki.find3.data.model.LearnData
import retrofit2.Retrofit
import java.io.IOException
import javax.inject.Inject

class Find3Service @Inject constructor(
        retrofit: Retrofit,
        private val appExecutors: AppExecutors
) {

    private val api = retrofit.create(Find3RestApi::class.java)

    suspend fun sendLearnData(learnData: LearnData) = withContext(appExecutors.network) {
        try {
            api.sendLearnData(learnData).execute()
        } catch (ioe: IOException) {
            //TODO log
        }

    }
}
