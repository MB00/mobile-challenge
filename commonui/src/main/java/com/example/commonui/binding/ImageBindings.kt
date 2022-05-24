package com.example.commonui.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter(value=["image"])
fun bindImage(
    imageView: ImageView,
    imageUrl: String
) {
    Glide.with(imageView.context).load(imageUrl).centerCrop().into(imageView)
}