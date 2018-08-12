package pl.ogiba.checky.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import pl.ogiba.checky.model.DailyRate

class HomeViewModel: ViewModel() {
    val dailyRates: MutableLiveData<ArrayList<DailyRate>> = MutableLiveData()

    val testValue: MutableLiveData<String> = MutableLiveData()

    var counter = 0
}