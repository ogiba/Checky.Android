package pl.ogiba.checky.model

import com.google.gson.annotations.SerializedName

class DailyRate {
    @SerializedName("table")
    var table: String? = null

    @SerializedName("no")
    var tableNo: String? = null

    @SerializedName("effectiveDate")
    var effectiveDate: String? = null

    @SerializedName("rates")
    var rates: ArrayList<Currency> = ArrayList()
}