package com.tawajood.daggerhilt.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tawajood.daggerhilt.databinding.RestaurantItemBinding
import com.tawajood.daggerhilt.pojo.RestaurantItem

class RestaurantAdapter: ListAdapter<RestaurantItem, RestaurantAdapter.RestaurantViewHolder>(
    RestaurantComparator()
){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val binding = RestaurantItemBinding.inflate(LayoutInflater.from(parent.context),
            parent , false)
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null){
            holder.bind(currentItem)
        }
    }

    class RestaurantViewHolder(private val binding: RestaurantItemBinding):
        RecyclerView.ViewHolder(binding.root){
            fun bind(restaurantItem: RestaurantItem){

                Glide.with(itemView)
                    .load(restaurantItem.logo)
                    .into(binding.restaurantImage)

                binding.apply {
                    restaurantNameTv.text = restaurantItem.name
                    restaurantTypeTv.text = restaurantItem.type
                    addressTv.text = restaurantItem.address
                }
            }
        }

    class RestaurantComparator: DiffUtil.ItemCallback<RestaurantItem>(){
        override fun areItemsTheSame(oldItem: RestaurantItem, newItem: RestaurantItem) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: RestaurantItem, newItem: RestaurantItem) =
            oldItem == newItem
    }
}