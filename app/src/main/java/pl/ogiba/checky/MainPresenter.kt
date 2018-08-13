package pl.ogiba.checky

import pl.ogiba.checky.model.DailyRate
import pl.ogiba.checky.network.ResponseListener
import pl.ogiba.checky.network.TableService
import pl.ogiba.checky.network.TableType

class MainPresenter : IMainPresenter {

    var mainView: IMainView? = null

    val tableService: TableService = TableService()

    override fun subscribe(view: IMainView) {
        this.mainView = view
    }

    override fun unsubscribe() {
        this.mainView = null
    }

    override fun loadData() {
        tableService.getLatest(TableType.A, object : ResponseListener<DailyRate, String> {
            override fun onSuccess(statusCode: Int, item: DailyRate?) {
                mainView?.onDailyRateLoaded(item)
            }

            override fun onError(statusCode: Int, error: String?, rawError: String?) {
                print(error)
                print(rawError)
            }
        })
    }
}