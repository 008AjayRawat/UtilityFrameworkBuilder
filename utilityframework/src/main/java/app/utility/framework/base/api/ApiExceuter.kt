package app.utility.framework.base.api

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiExecutor {
    companion object {
        fun <T> getResponse(requestCode: Int, call: Call<T>, callback: ModelApiCallback) {
            callback.onExecutorStart(requestCode)
            call.enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    if (response.isSuccessful) callback.onResponse(requestCode, call.request(), response.body())
                    else callback.onError(requestCode, call.request(), response.errorBody())
                    callback.onExecutorStop(requestCode)
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    callback.onFailure(requestCode, call.request(), t)
                    callback.onExecutorStop(requestCode)
                }
            })
        }
    }
}

