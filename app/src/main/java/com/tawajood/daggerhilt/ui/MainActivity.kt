package com.tawajood.daggerhilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.tawajood.daggerhilt.R
import com.tawajood.daggerhilt.adapters.RestaurantAdapter
import com.tawajood.daggerhilt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = RestaurantAdapter()


        binding.apply {
            restaurantsRv.adapter = adapter
            viewModel.restaurantLiveData.observe(this@MainActivity){
                adapter.submitList(it)
            }
        }

    }
}