package pl.ogiba.checky

import pl.ogiba.checky.model.DailyRate

interface IMainPresenter {
    fun subscribe(view: IMainView)

    fun unsubscribe()

    fun loadData()

    fun convertToViewItems(dailyRates: ArrayList<DailyRate>?)
}