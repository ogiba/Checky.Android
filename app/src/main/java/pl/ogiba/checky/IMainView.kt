package pl.ogiba.checky

import pl.ogiba.checky.model.DailyRate

interface IMainView {
    fun onSubscribe()

    fun onDailyRateLoaded(dailyRate: DailyRate?)
}