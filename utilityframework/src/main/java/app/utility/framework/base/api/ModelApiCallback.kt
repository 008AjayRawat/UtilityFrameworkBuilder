package app.utility.framework.base.api

import okhttp3.Request
import okhttp3.ResponseBody

interface ModelApiCallback {

    fun onResponse(requestCode: Int, request: Request?, response: Any?)

    fun onFailure(requestCode: Int, request: Request?, t: Throwable)

    fun onError(requestCode: Int, request: Request?, responseBody: ResponseBody?)

    fun onExecutorStart(requestCode: Int)

    fun onExecutorStop(requestCode: Int)

}