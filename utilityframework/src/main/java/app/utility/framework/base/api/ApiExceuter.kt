package app.utility.framework.base.api

import app.utility.framework.retrofit.RetrofitRequest
import app.utility.framework.retrofit.RetrofitResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiExecutor {
    companion object {
        fun <T> getResponse(requestCode: Int, call: Call<T>, callback: ModelApiCallback) {
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
    }
}

