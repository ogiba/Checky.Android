package pl.ogiba.checky


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import pl.ogiba.checky.adapter.DailyRatesAdapter
import pl.ogiba.checky.model.DailyRate
import pl.ogiba.checky.viewitems.RateViewItem
import pl.ogiba.checky.viewmodels.HomeViewModel

class MainActivity : FragmentActivity(), IMainView {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var presenter: IMainPresenter
    private val adapter = DailyRatesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        setupRecyclerView()

        btnTest.setOnClickListener {
            presenter.loadData()
        }

        homeViewModel.dailyRates.observe(this, Observer {
            presenter.convertToViewItems(it)
        })

        homeViewModel.rateViewItems.observe(this, Observer {
            if (it != null) {
                adapter.addItems(it)
            }
        })

        homeViewModel.testValue.observe(this, Observer {
            tvPlaceholder?.text = it
        })

        presenter = MainPresenter()
        presenter.subscribe(this)
    }

    override fun onDestroy() {
        presenter.unsubscribe()
        super.onDestroy()
    }

    override fun onSubscribe() {

    }

    override fun onDailyRateLoaded(dailyRate: DailyRate?) {
        if (dailyRate != null) {
            homeViewModel.testValue.value = dailyRate.effectiveDate
            homeViewModel.dailyRates.value?.add(dailyRate)
        }
    }

    override fun onViewItemsPrepared(viewItems: ArrayList<RateViewItem>) {
        homeViewModel.rateViewItems.value = viewItems
    }

    private fun setupRecyclerView() {
        rvDailyRates.layoutManager = LinearLayoutManager(this)
        rvDailyRates.adapter = adapter
    }
}
