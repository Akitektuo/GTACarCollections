package com.akitektuo.gtacarcollections

import android.content.Context

class Preferences(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("init", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    fun set(string: String) {
        editor.putString("values", string)
        editor.commit()
    }

    fun get() = sharedPreferences.getString("values", "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0")

}