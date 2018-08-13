package pl.ogiba.checky.network

import io.reactivex.Observable
import pl.ogiba.checky.model.DailyRate
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface NbpApi {
    @GET("{tableName}")
    fun getLatest(@Path("tableName") tableName: String): Observable<Response<ArrayList<DailyRate>>>
}