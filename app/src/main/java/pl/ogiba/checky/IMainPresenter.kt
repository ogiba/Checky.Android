package pl.ogiba.checky

interface IMainPresenter {
    fun subscribe(view: IMainView)

    fun unsubscribe()

    fun loadData()
}