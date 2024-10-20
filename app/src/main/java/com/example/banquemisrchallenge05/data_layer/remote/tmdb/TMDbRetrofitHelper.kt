package com.example.banquemisrchallenge05.data_layer.remote.tmdb


import com.example.banquemisrchallenge05.utils.constants.APIKeys
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File


object TMDbRetrofitHelper {

    private fun getCacheDir(): File {
        val cachePath = "${System.getProperty("java.io.tmpdir")}/httpCache"
        return File(cachePath).apply { mkdirs() }
    }

    val api: TMDbAPIServices by lazy {
        val cacheSize = 10 * 1024 * 1024
        val cache = Cache(getCacheDir(), cacheSize.toLong())

        val headerInterceptor = Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader(APIKeys.AUTHORIZATION_HEADER, APIKeys.API_READ_ACCESS_TOKEN)
                .build()
            chain.proceed(request)
        }

        val clientBuilder = OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
            .cache(cache)

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

