package pl.ogiba.checky.utils

import android.support.v7.util.DiffUtil
import pl.ogiba.checky.viewitems.RateViewItem

class DailyRateDiffCallback(val oldDailyRates: ArrayList<RateViewItem>,
                            val newDailyRates: ArrayList<RateViewItem>) : DiffUtil.Callback() {


    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldDailyRates[oldItemPosition].label == newDailyRates[newItemPosition].label
    }

    override fun getOldListSize(): Int {
        return oldDailyRates.size
    }

    override fun getNewListSize(): Int {
        return newDailyRates.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldDailyRates[oldItemPosition] == newDailyRates[newItemPosition]
    }
}