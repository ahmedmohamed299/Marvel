package com.example.marvel.presentation.ui.home


import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvel.R
import com.example.marvel.data.character.CharacterModel
import com.example.marvel.data.utils.Resource
import com.example.marvel.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val adapter = HomeAdapter()
    private val binding
        get() = _binding!!
    var paginatedValue = 0
    private lateinit var layoutManager : LinearLayoutManager

    private val viewModel: HomeViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater,container,false)

        Glide.with(binding.ivLogo.context).load(R.drawable.marvel_logo).into(binding.ivLogo)
        getData()
        onClick()

        recyclerInit()



        return binding.root
    }

    private fun onClick() {
        binding.ivSearch.setOnClickListener {
            findNavController().navigate(R.id.searchFragment)
        }

    }

    private fun recyclerInit() {
        viewModel.getCharacters(paginatedValue.toString())
        layoutManager = LinearLayoutManager(requireActivity())
        binding.rvHome.layoutManager= layoutManager
        binding.rvHome.adapter =adapter


        binding.rvHome.addOnScrollListener(object : RecyclerView.OnScrollListener(){

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (layoutManager.findLastVisibleItemPosition()==layoutManager.itemCount-1){
                    paginatedValue +=5
                    viewModel.getCharacters(paginatedValue.toString())
                    Log.d("TAG", "onScrollStateChanged: $paginatedValue")
                }
            }
        })
    }


    private fun getData(){
        Log.d("tag", "Ahmed:  ")
        viewModel.characterLiveData.observe(viewLifecycleOwner){
            Log.d("tag", "AhmedObserve:  ")

            when(it){
                is Resource.Error ->{
                    Log.d("tag", "getData: ${it.message} ")
                }
                is Resource.Loading ->{

                }
                is Resource.Success ->{
                    adapter.setData(it.data?.characterModels!!  as ArrayList<CharacterModel>)
                    Log.d("tag", "getDataAhmed: ${it.data} ")

                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}