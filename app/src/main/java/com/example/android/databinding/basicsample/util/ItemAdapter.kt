package com.example.android.databinding.basicsample.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.databinding.basicsample.data.ItemViewModel
import com.example.android.databinding.basicsample.databinding.ItemBinding

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  ItemViewHolder =
    ItemViewHolder(ItemBinding.inflate(LayoutInflater.from(parent?.context), parent, false))

    var items = listOf<ItemViewModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    inner class ItemViewHolder(private val itemBinding: ItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(itemViewModel: ItemViewModel) {
            itemBinding.item = itemViewModel
            itemBinding.executePendingBindings()
        }
    }
}
