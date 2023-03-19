package com.example.marvel.presentation.ui.home

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.data.character.CharacterModel
import com.example.marvel.databinding.ItemHeroBinding

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var charactersList = ArrayList<CharacterModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(characters: ArrayList<CharacterModel>) {
        charactersList.addAll(characters)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemHeroBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HomeViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(charactersList[position])

    }

    override fun getItemCount(): Int = charactersList.size

     class HomeViewHolder(private val binding: ItemHeroBinding) :
        RecyclerView.ViewHolder(binding.root) {

         private var characterModel =CharacterModel()
         fun onClick(){

            val action= HomeFragmentDirections.actionHomeFragmentToDetailsFragment(characterModel)
            binding.root.findNavController().navigate(action)
        }
        fun bind(characterModel: CharacterModel) {
            this.characterModel=characterModel

            binding.character = characterModel


            binding.adapter=this
        }
    }



}