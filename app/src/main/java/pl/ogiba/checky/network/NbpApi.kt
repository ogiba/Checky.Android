package pl.ogiba.checky.network

import pl.ogiba.checky.model.DailyRate
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface NbpApi {
    @GET("exchangerates/tables/{tableName}")
    fun getLatest(@Path("tableName") tableName: String): Call<ArrayList<DailyRate>>
}