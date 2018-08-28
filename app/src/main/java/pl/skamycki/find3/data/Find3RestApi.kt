package pl.skamycki.find3.data

import pl.skamycki.find3.data.model.LearnData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Find3RestApi {

    @POST("/data")
    fun sendLearnData(@Body learnData: LearnData): Call<Void>
}
