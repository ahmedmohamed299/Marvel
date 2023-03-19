package com.example.marvel.presentation

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.marvel.R
import com.squareup.picasso.Picasso
import java.lang.Exception

@BindingAdapter("setImage")
fun bindImage(imageView: ImageView,url:String){


    Picasso.get().load(url).placeholder(R.drawable.image_placeholder)
        .into(object : com.squareup.picasso.Target {
            override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
              imageView.setImageBitmap(bitmap)
                imageView.scaleType =ImageView.ScaleType.CENTER_CROP


            }

            override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {

            }

            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
            }

        })
}