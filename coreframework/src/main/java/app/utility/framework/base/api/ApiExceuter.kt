package app.utility.framework.base.api

import app.utility.framework.apiexecutors.retrofit.RetrofitExecutor
import retrofit2.Call

class ApiExecutor {

    val retrofitExecutor: RetrofitExecutor = RetrofitExecutor()

    enum class ExecutorType {
        RETROFIT, VOLLEY, HTTPCLIENT, RXJAVA
    }


    fun getResponse(executorType: ExecutorType = ExecutorType.RETROFIT, requestCode: Int, api: IApiRequestProvider, callback: ApiCallback) {
        when (executorType) {
            ExecutorType.RETROFIT -> retrofitExecutor.getResponse(requestCode, api.provideApiRequest(requestCode) as Call<*>, callback)
            ExecutorType.VOLLEY -> TODO()
            ExecutorType.HTTPCLIENT -> TODO()
            ExecutorType.RXJAVA -> TODO()
        }
    }

//    companion object {
//        val retrofitExecutor: RetrofitExecutor = RetrofitExecutor()
//
//        val mRetrofitInstance: Retrofit = RetrofitClient.getRetrofitInstance()
//
//        fun <T> getResponse(requestCode: Int, call: Call<T>, callback: ApiCallback) {
//            callback.onExecutorStart(requestCode)
//            call.enqueue(object : Callback<T> {
//                override fun onResponse(call: Call<T>, response: Response<T>) {
//                    callback.onExecutorStop(requestCode)
//
//                    val requestHandler: IBaseRequest = RetrofitRequest(call)
//                    val responseHandler: IBaseResponse = RetrofitResponse(response)
//
//                    if (response.isSuccessful) callback.onResponse(requestCode, requestHandler, responseHandler)
//                    else callback.onError(requestCode, requestHandler, responseHandler)
//                }
//
//                override fun onFailure(call: Call<T>, t: Throwable) {
//                    callback.onExecutorStop(requestCode)
//
//                    val requestHandler: IBaseRequest = RetrofitRequest(call)
//                    callback.onFailure(requestCode, requestHandler, t)
//                }
//            })
//        }
//    }
}

