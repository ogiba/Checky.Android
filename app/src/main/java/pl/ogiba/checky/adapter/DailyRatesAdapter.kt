package pl.ogiba.checky.adapter

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import pl.ogiba.checky.R
import pl.ogiba.checky.utils.DailyRateDiffCallback
import pl.ogiba.checky.viewitems.RateViewItem

class DailyRatesAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val items: ArrayList<RateViewItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.rv_rate_item, parent, false)
        return RateItemViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is RateItemViewHolder) {
            holder.labeView.text = items[position].label
        }
    }

    public fun addItems(items: ArrayList<RateViewItem>) {
        val diffResult = DiffUtil.calculateDiff(DailyRateDiffCallback(this.items, items))
        diffResult.dispatchUpdatesTo(this)
    }
}