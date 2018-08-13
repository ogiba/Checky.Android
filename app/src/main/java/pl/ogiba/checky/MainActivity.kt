package pl.ogiba.checky


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_main.*
import pl.ogiba.checky.model.DailyRate
import pl.ogiba.checky.viewmodels.HomeViewModel

class MainActivity : FragmentActivity(), IMainView {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var presenter: IMainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        btnTest.setOnClickListener {
//            homeViewModel.testValue.value = "${homeViewModel.counter++}"
            presenter.loadData()
        }

        homeViewModel.dailyRates.observe(this, Observer {

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
        homeViewModel.testValue.value = dailyRate?.effectiveDate
    }
}
