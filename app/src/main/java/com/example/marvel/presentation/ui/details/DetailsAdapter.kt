package com.example.marvel.presentation.ui.details

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.data.character.Item
import com.example.marvel.databinding.ItemDetailsBinding

class DetailsAdapter:RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder>() {

    private var itemList=ArrayList<Item?>()
    @SuppressLint("NotifyDataSetChanged")
    fun setData(item:List<Item?>){
        itemList.clear()
        itemList.addAll(item)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        val binding=ItemDetailsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DetailsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        holder.bind(itemList[position]!!)
    }
    override fun getItemCount(): Int =itemList.size

    class DetailsViewHolder(val binding: ItemDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {

            binding.item=item
        }
    }
}