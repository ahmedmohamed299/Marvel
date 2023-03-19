package com.example.marvel.presentation.ui.search

import android.graphics.Color
import android.graphics.RenderEffect
import android.graphics.Shader
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.marvel.data.utils.Resource
import com.example.marvel.databinding.FragmentSearchBinding
import com.example.marvel.presentation.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class SearchFragment : Fragment() {

    val viewModel: HomeViewModel by viewModels()
    var adapter = SearchAdapter()
    var _binding: FragmentSearchBinding? = null

    val binding: FragmentSearchBinding
        get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSearchBinding.inflate(inflater, container, false)

        binding.rvSearch.adapter = adapter

        observe()
        blur()
        onCLick()


        return binding.root
    }

    private fun blur() {
        requireActivity().window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
            binding.blur.setRenderEffect(
                RenderEffect.createBlurEffect(
                    40f, 40f, Shader.TileMode.MIRROR
                )
            )
        }


    }

    private fun observe() {
        viewModel.searchLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    Log.d("TAG", "onCreateView:searchLiveData ${it.data} ")
                    adapter.setData(it.data!!)
                }
                is Resource.Loading -> {

                }
                is Resource.Error -> {
                    Log.d("TAG", "onCreateView:searchLiveData Error ${it.message} ")

                }
            }
        }

    }

    private fun onCLick() {

        binding.cancel.setOnClickListener {
            Navigation.findNavController(requireView()).popBackStack()

        }


        binding.searchView.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                viewModel.getSearchCharacters(s.toString())
            }

        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}