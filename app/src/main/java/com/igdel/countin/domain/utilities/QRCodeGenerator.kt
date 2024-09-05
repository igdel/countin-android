package com.igdel.countin.domain.utilities

import android.graphics.Bitmap

interface QRCodeGenerator {
    fun generateQRCode(text: String, width: Int, height: Int): Bitmap?  // TODO FIX IMPORTING ANDROID SPECIFIC LIBRARY
}