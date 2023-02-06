package com.example.foodlist
import android.content.Context

class MySharedPref(context: Context) {

    companion object {
        private const val KEY = "key"
        private const val Font_size = "size"
    }

    private val sharedPref = context.getSharedPreferences(KEY, Context.MODE_PRIVATE)

    fun saveSize(s: String){
        sharedPref.edit()
            .putString(Font_size, s)
            .apply()
    }

    fun getSize(): String? {
        return sharedPref.getString(Font_size, null)
    }
}