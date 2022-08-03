package com.example.mimovie.core

import com.google.gson.Gson
import com.google.gson.GsonBuilder

object RetrofitHelper {

    var gson: Gson = GsonBuilder()
        .setLenient()
        .create()

}