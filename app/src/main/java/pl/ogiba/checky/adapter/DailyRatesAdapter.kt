package pl.ogiba.checky.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

class DailyRatesAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val items: ArrayList<Any> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}