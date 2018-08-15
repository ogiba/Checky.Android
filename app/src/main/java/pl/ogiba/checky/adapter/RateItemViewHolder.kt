package pl.ogiba.checky.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import pl.ogiba.checky.R

class RateItemViewHolder : RecyclerView.ViewHolder {

    val labeView: TextView

    constructor(itemView: View) : super(itemView) {
        labeView = itemView.findViewById(R.id.tv_label)
    }
}