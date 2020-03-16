package com.example.lab8.Interface

import com.example.lab8.Model.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


private val retrofit = Retrofit.Builder()
    .baseUrl("https://api.github.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface GitHubApi {

    @GET("users/{user}")
    fun getUser(@Path("user") user:String?): Call<User>


}

object Gitapi{
    val retrofitService: GitHubApi by lazy{
        retrofit.create(GitHubApi::class.java)
    }
}