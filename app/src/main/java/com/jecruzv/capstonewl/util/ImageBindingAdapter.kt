package com.jecruzv.capstonewl.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.jecruzv.local.Constants

@BindingAdapter("android:src")
fun loadImage(imageView: ImageView, url: String?) {
    Glide.with(imageView.context)
        .load(Constants.BASE_POSTER_IMAGE_URL + url)
        .into(imageView)
}