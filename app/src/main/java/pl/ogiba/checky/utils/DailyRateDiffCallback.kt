package pl.ogiba.checky.utils

import android.support.v7.util.DiffUtil
import pl.ogiba.checky.model.DailyRate

class DailyRateDiffCallback(val oldDailyRates: ArrayList<DailyRate>,
                            val newDailyRates: ArrayList<DailyRate>) : DiffUtil.Callback() {


    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldDailyRates[oldItemPosition].effectiveDate == newDailyRates[newItemPosition].effectiveDate
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