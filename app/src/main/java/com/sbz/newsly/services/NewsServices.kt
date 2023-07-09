package com.sbz.newsly.services

import com.google.gson.Gson
import com.sbz.newsly.model.NewsModel
import com.sbz.newsly.util.API_KEY
import com.sbz.newsly.util.BASE_URL
import com.sbz.newsly.util.END_POINT
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsServices {

    @GET("$END_POINT?apiKey=$API_KEY")
    fun getHeadLines(@Query("country") country: String, @Query("page") page: Int): Call<NewsModel>
}

