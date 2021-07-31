package com.tawajood.daggerhilt.api

import com.tawajood.daggerhilt.pojo.RestaurantResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitApi {
    companion object{
        const val BASE_URL = "https://random-data-api.com/api/"
    }

    @GET("restaurant/random_restaurant?size=20")
    suspend fun getRestaurants(): Response<RestaurantResponseBody>
}