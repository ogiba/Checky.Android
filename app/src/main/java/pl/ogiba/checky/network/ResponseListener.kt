package pl.ogiba.checky.network

interface ResponseListener<I, E> {
    fun onSuccess(statusCode: Int, item: I?)

    fun onError(statusCode: Int, error: E?, rawError: String? = null)
}