package pl.ogiba.checky.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class BaseRestService<T>(service: Class<T>) {

    protected val service: T

    protected var apiHost: String = String()

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(apiHost)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        this.service = retrofit.create(service)
    }
}