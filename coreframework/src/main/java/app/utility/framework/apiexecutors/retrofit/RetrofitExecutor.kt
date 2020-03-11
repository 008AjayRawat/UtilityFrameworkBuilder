package app.utility.framework.apiexecutors.retrofit

import app.utility.framework.base.api.ApiCallback
import app.utility.framework.base.api.IBaseRequest
import app.utility.framework.base.api.IBaseResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class RetrofitExecutor {
    private val retrofit: Retrofit = RetrofitClient.getRetrofitInstance()

    fun <T> getApiService(serviceName: Class<T>): T {
        return retrofit.create(serviceName)
    }

    fun <T> getResponse(requestCode: Int, call: Call<T>, callback: ApiCallback) {
        callback.onExecutorStart(requestCode)
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                callback.onExecutorStop(requestCode)

                val requestHandler: IBaseRequest = RetrofitRequest(call)
                val responseHandler: IBaseResponse = RetrofitResponse(response)

                if (response.isSuccessful) callback.onResponse(requestCode, requestHandler, responseHandler)
                else callback.onError(requestCode, requestHandler, responseHandler)
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                callback.onExecutorStop(requestCode)

                val requestHandler: IBaseRequest = RetrofitRequest(call)
                callback.onFailure(requestCode, requestHandler, t)
            }
        })
    }


//    fun <T> getResponse(requestCode: Int, call: Call<T>, callback: ApiCallback) {
//        callback.onExecutorStart(requestCode)
//        call.enqueue(object : Callback<T> {
//            override fun onResponse(call: Call<T>, response: Response<T>) {
//                callback.onExecutorStop(requestCode)
//
//                val requestHandler: IBaseRequest = RetrofitRequest(call)
//                val responseHandler: IBaseResponse = RetrofitResponse(response)
//
//                if (response.isSuccessful) callback.onResponse(requestCode, requestHandler, responseHandler)
//                else callback.onError(requestCode, requestHandler, responseHandler)
//            }
//
//            override fun onFailure(call: Call<T>, t: Throwable) {
//                callback.onExecutorStop(requestCode)
//
//                val requestHandler: IBaseRequest = RetrofitRequest(call)
//                callback.onFailure(requestCode, requestHandler, t)
//            }
//        })
//    }
}