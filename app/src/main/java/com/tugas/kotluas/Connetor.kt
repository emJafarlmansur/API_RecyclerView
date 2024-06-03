package com.tugas.kotluas

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Connetor {
    val endpoint:InterfaceEndpoint
    get(){
        val interceptor = HttpLoggingInterceptor()
        interceptor.level=HttpLoggingInterceptor.Level.BODY

        val client=OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit=Retrofit.Builder()
            .baseUrl("http://192.168.214.244/Server_Api/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(InterfaceEndpoint::class.java)
    }
}