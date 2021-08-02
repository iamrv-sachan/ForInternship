package com.rajdroid.forinternship

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val API_KEY="fdc8e9b04d2e418094b7644a116bc555"
val baseURL = "https://newsapi.org/v2/"
interface retroServiceInterface {
    //https://newsapi.org/v2/everything?q=bollywood&apiKey=fdc8e9b04d2e418094b7644a116bc555
//    https://newsapi.org/v2/everything/users/cricket/?apikey=fdc8e9b04d2e418094b7644a116bc555
//    @GET("everything?&apiKey=$API_KEY")
//    fun getDataFromAPI(@Query("q") q: String): Call<News>?
    @Headers("x-api-key:$API_KEY")
    @GET("everything")
    fun getDataFromAPI(
        @Query("q") query: String?
    ): Call<News>
}

object RetrofitInstance{
    val cricInstance:retroServiceInterface
    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        cricInstance=retrofit.create(retroServiceInterface::class.java)
    }
}