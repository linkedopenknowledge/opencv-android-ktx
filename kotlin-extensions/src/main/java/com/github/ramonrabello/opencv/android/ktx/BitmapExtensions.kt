package com.github.ramonrabello.opencv.android.ktx

import android.graphics.Bitmap
import org.opencv.android.Utils
import org.opencv.core.Mat

/**
 * Converts [Bitmap] to a [Mat].
 */
fun Bitmap.toMat() : Mat {
    val mat = Mat()
    Utils.bitmapToMat(this, mat)
    return mat
}