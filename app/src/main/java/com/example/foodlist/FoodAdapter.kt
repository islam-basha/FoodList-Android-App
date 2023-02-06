package com.example.foodlist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foodlist.databinding.FoodListItemsBinding

class FoodAdapter: ListAdapter<Food, RecyclerView.ViewHolder>(DIFF_CALLBACK){

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Food>() {

            override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
                return oldItem.name == newItem.name || oldItem.imageUrl == newItem.imageUrl
            }

        }
    }

    private lateinit var binding: FoodListItemsBinding
     var size="24dp"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        binding = FoodListItemsBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder){
            val item = getItem(position)
            holder.bind(item)
        }
    }


    inner class ViewHolder(val itemBinding: FoodListItemsBinding):
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Food){
            itemBinding.tvName.text = item.name
            itemBinding.tvName.textSize=size.toFloat()
            itemBinding.tvName.setOnClickListener {
                Toast.makeText(it.context,"name: ${item.name}",Toast.LENGTH_LONG).show()
            }
            itemBinding.imageView.setImageResource(item.imageUrl)
        }
    }
}