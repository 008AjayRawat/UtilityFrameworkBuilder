package app.utility.framework.base.response

import app.utility.framework.base.api.IBaseRequest
import app.utility.framework.base.api.IBaseResponse

data class ResponseState(val requestCode: Int, val status: Status, val request: IBaseRequest?, val response: IBaseResponse?, val exp: Throwable?) {
    enum class Status {
        EXECUTOR_STARTED, EXECUTOR_FINISHED, SUCCESS, ERROR
    }
}