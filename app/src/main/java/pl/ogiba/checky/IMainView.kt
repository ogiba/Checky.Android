package pl.ogiba.checky

import pl.ogiba.checky.model.DailyRate
import pl.ogiba.checky.viewitems.RateViewItem

interface IMainView {
    fun onSubscribe()

    fun onDailyRateLoaded(dailyRate: DailyRate?)

    fun onViewItemsPrepared(viewItems: ArrayList<RateViewItem>)
}