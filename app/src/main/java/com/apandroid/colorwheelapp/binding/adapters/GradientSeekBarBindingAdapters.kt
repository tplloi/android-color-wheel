package com.apandroid.colorwheelapp.binding.adapters

import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import com.apandroid.colorwheel.gradientseekbar.GradientSeekBar
import com.apandroid.colorwheel.gradientseekbar.setAlphaListener
import com.apandroid.colorwheel.gradientseekbar.setBlackToColor
import com.apandroid.colorwheel.gradientseekbar.setTransparentToColor

interface GradientSeekBarOnColorChangedListener {

    fun onColorChanged(color: Int)
}

interface GradientSeekBarOnAlphaChangedListener {

    fun onAlphaChanged(alpha: Int)
}

@BindingAdapter("transparentToColor")
fun GradientSeekBar.bindTransparentToColor(argb: Int) {
    this.setTransparentToColor(argb, false)
}

@BindingAdapter("blackToColor")
fun GradientSeekBar.bindBlackToColor(argb: Int) {
    this.setBlackToColor(argb)
}

@BindingAdapter("colorListener")
fun GradientSeekBar.bindOnColorChangedListener(listener: GradientSeekBarOnColorChangedListener) {
    this.colorListener = { _, argb -> listener.onColorChanged(argb) }
}

@BindingAdapter("alphaListener")
fun GradientSeekBar.bindAlphaChangeListener(listener: GradientSeekBarOnAlphaChangedListener) {
    this.setAlphaListener { _, _, alpha -> listener.onAlphaChanged(alpha) }
}

@BindingAdapter("offset")
fun GradientSeekBar.bindOffset(offset: Float) {
    if (this.offset != offset) this.offset = offset
}

@InverseBindingAdapter(attribute = "offset")
fun GradientSeekBar.receiveOffset() = this.offset

@BindingAdapter("offsetAttrChanged")
fun GradientSeekBar.bindOffsetListener(listener: InverseBindingListener) {
    this.colorListener = { _, _ -> listener.onChange() }
}
