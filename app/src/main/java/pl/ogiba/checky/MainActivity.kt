package pl.ogiba.checky


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import pl.ogiba.checky.model.DailyRate
import pl.ogiba.checky.network.ResponseListener
import pl.ogiba.checky.network.TableService
import pl.ogiba.checky.network.TableType
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

        val tableService = TableService().getLatest(TableType.A, object : ResponseListener<DailyRate, String> {
            override fun onSuccess(statusCode: Int, item: DailyRate?) {
                print(item)
            }

            override fun onError(statusCode: Int, error: String?, rawError: String?) {
                print(error)
                print(rawError)
            }
        })

    }
}
