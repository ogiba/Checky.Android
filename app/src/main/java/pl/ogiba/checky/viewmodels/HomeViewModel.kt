package pl.ogiba.checky.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import pl.ogiba.checky.model.DailyRate
import pl.ogiba.checky.viewitems.RateViewItem

class HomeViewModel : ViewModel() {
    val dailyRates: MutableLiveData<ArrayList<DailyRate>> = MutableLiveData()
    val rateViewItems: MutableLiveData<ArrayList<RateViewItem>> = MutableLiveData()

    val testValue: MutableLiveData<String> = MutableLiveData()

    var counter = 0
}