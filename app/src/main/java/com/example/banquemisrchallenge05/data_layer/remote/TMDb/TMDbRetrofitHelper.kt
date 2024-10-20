package com.example.e_store.utils.data_layer.remote.shopify

import com.example.banquemisrchallenge05.utils.constants.APIKeys
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object TMDbRetrofitHelper {

    val api: TMDbAPIServices by lazy {

        val headerInterceptor = Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader(APIKeys.AUTHORIZATION_HEADER, APIKeys.API_READ_ACCESS_TOKEN)
                .build()
            chain.proceed(request)
        }

        val clientBuilder = OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)


        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        clientBuilder.addInterceptor(logging)


        val client = clientBuilder.build()

        Retrofit.Builder()
            .baseUrl(APIKeys.TMDB_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TMDbAPIServices::class.java)
    }
}





