package app.utility.framework.base.response

data class ResponseState(val requestCode: Int, val status: Status, val data: Any?, val exp: Throwable?) {
    enum class Status {
        EXECUTOR_STARTED, EXECUTOR_FINISHED, SUCCESS, ERROR
    }
}