package pl.ogiba.checky


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import pl.ogiba.checky.viewmodels.HomeViewModel

class MainActivity : android.support.v4.app.FragmentActivity() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        btnTest.setOnClickListener {
            homeViewModel.testValue.value = "${homeViewModel.counter++}"
        }

        homeViewModel.dailyRates.observe(this, Observer {

        })

        homeViewModel.testValue.observe(this, Observer {
            tvPlaceholder?.text = it
        })

    }
}
