package com.example.marvel.presentation.ui.search

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.data.character.CharacterModel
import com.example.marvel.databinding.ItemSearchBinding
import com.squareup.picasso.Picasso

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    private val charactersList =ArrayList<CharacterModel>()
    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<CharacterModel>){
        charactersList.clear()
        charactersList.addAll(list)
        notifyDataSetChanged()
    }

    class SearchViewHolder(val binding: ItemSearchBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(characterModel: CharacterModel) {
            Picasso.get().load(characterModel.thumbnail?.path +characterModel.thumbnail?.extension).into(binding.ivHero)
            binding.tvName.text=characterModel.name
            binding.container.setOnClickListener {
                val action = SearchFragmentDirections.actionSearchFragmentToDetailsFragment(characterModel)
                it.findNavController().navigate(action)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(ItemSearchBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int =charactersList.size

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
       holder.bind(charactersList[position])
    }
}