package com.example.recyclerviewproject

import android.widget.TextView
import androidx.databinding.BindingAdapter

class UserBindingAdapter {
    companion object{
        @BindingAdapter("customText")
        @JvmStatic
        fun setCustomText(view: TextView, item: String) {
            view.text = "Name: $item"
        }

        @BindingAdapter("customEmail")
        @JvmStatic
        fun TextView.setCustomEmail(item: String) {
            text = "Email: $item"
        }
    }
}