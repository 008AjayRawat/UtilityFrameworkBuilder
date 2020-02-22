package app.framework.base.api

interface ApiCallback {

    fun onExecutorStart(requestCode: Int)

    fun onExecutorStop(requestCode: Int)

    fun onResponse(requestCode: Int, request: IBaseRequest?, response: IBaseResponse?)

    fun onFailure(requestCode: Int, request: IBaseRequest?, t: Throwable?)

    fun onError(requestCode: Int, request: IBaseRequest?, response: IBaseResponse?)

}