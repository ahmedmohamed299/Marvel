package com.example.marvel.presentation.ui.details

import android.graphics.Bitmap
import android.graphics.RenderEffect
import android.graphics.Shader
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.marvel.data.character.CharacterModel
import com.example.marvel.data.character.Comics
import com.example.marvel.databinding.FragmentDetailsBinding
import com.squareup.picasso.Picasso
import kotlinx.parcelize.RawValue
import java.lang.Exception


class DetailsFragment : Fragment() {

    lateinit var binding: FragmentDetailsBinding
    private val args: DetailsFragmentArgs by navArgs()
    lateinit var adapter: DetailsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater)

        onClick()

        val character = args.character
        binding.character = character

        Picasso.get().load("${character.thumbnail?.path}.${character.thumbnail?.extension}")
            .into(object : com.squareup.picasso.Target {
                @RequiresApi(Build.VERSION_CODES.S)
                override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                    binding.blur.apply {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                            setRenderEffect(
                                RenderEffect.createBlurEffect(
                                    50f, 50f, Shader.TileMode.REPEAT
                                )
                            )
                        }

                        setImageBitmap(bitmap)
                        alpha=0.3f
                    }
                }

                override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                }

                override fun onPrepareLoad(placeHolderDrawable: Drawable?) {

                }

            })

        recyclerInit(character)
        return binding.root
    }

    private fun onClick() {

        binding.ivBack.setOnClickListener {
            Navigation.findNavController(requireView()).popBackStack()
        }
    }

    private fun recyclerInit(character: CharacterModel) {
        rvComicsInit(character.comics)
        rvEventsInit(character.events)
        rvSeriesInit(character.series)
        rvStoriesInit(character.stories)
    }

    private fun rvComicsInit(comics: @RawValue Comics?) {
        adapter = DetailsAdapter()
        binding.rvComics.adapter = adapter
        adapter.setData(comics?.items!!)

    }

    private fun rvEventsInit(events: @RawValue Comics?) {
        adapter = DetailsAdapter()
        binding.rvEvents.adapter = adapter
        adapter.setData(events?.items!!)

    }

    private fun rvSeriesInit(series: @RawValue Comics?) {
        adapter = DetailsAdapter()
        binding.rvSeries.adapter = adapter
        adapter.setData(series?.items!!)

    }

    private fun rvStoriesInit(stories: @RawValue Comics?) {
        adapter = DetailsAdapter()
        binding.rvStories.adapter = adapter
        adapter.setData(stories?.items!!)

    }


}