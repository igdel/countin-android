package com.igdel.countin.domain.utilities

import android.widget.ImageView

interface ImageLoader {
    fun load(imageView: ImageView, imageRes: Int) // TODO FIX IMPORTING ANDROID SPECIFIC LIBRARY
}