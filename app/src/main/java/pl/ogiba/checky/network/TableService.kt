package pl.ogiba.checky.network

import pl.ogiba.checky.model.DailyRate
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TableService : BaseRestService<NbpApi>(NbpApi::class.java) {

    fun getLatest(table: TableType, responseListener: ResponseListener<DailyRate, String>) {
        val call = service.getLatest(table.value)

        call.enqueue(object : Callback<ArrayList<DailyRate>> {
            override fun onFailure(call: Call<ArrayList<DailyRate>>?, t: Throwable?) {
                responseListener.onError(-1, null, t?.message)
            }

            override fun onResponse(call: Call<ArrayList<DailyRate>>?, response: Response<ArrayList<DailyRate>>?) {
                if (response != null) {
                    when (response.code()) {
                        200 -> responseListener.onSuccess(response.code(), response.body()?.get(0))
                    }
                }
            }
        })
    }
}