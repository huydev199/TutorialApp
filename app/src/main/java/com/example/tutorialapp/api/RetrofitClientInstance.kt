package com.example.tutorialapp.api

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClientInstance {
    private var retrofit: Retrofit? = null

    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }


    val authInterceptor = Interceptor { chain ->
        val newRequest = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer mytoken")
            .build()
        chain.proceed(newRequest)
    }

    val okHttpClient = OkHttpClient.Builder()
//        .addInterceptor(authInterceptor)
        .addInterceptor(loggingInterceptor)
        .build()

    var gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()

    val initRetrofit: Retrofit? get() {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(ApiConfig.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
        return retrofit
    }
}