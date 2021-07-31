package com.tawajood.daggerhilt.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tawajood.daggerhilt.api.RetrofitApi
import com.tawajood.daggerhilt.pojo.RestaurantResponseBody
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
    @Inject
    constructor(private val api: RetrofitApi): ViewModel() {

    private val restaurantMutableLiveData = MutableLiveData<RestaurantResponseBody>()
    val restaurantLiveData: LiveData<RestaurantResponseBody> = restaurantMutableLiveData

    init {
        viewModelScope.launch {
            val response = api.getRestaurants()
            if (response.isSuccessful){
                restaurantMutableLiveData.value = response.body()
            }else{
                Log.d("7ima", "error: ${response.message()}")
            }
        }
    }
}