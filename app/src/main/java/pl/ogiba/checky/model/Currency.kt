package pl.ogiba.checky.model

import com.google.gson.annotations.SerializedName

class Currency {
    @SerializedName("currency")
    var currency:String? = null

    @SerializedName("code")
    var code: String? = null

    var symbol: String? = null

    @SerializedName("mid")
    var midValue: Double = 0.0
}