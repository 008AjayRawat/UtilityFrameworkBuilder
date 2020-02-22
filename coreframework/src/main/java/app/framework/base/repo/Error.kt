package app.framework.base.repo

enum class Error(val code: Int, msg: String) {
    UNKNOWN_ERROR(0,"Unknown Error"),
    INTERNET_ERROR(1, "No Internet Connection"),
    SERVER_ERROR(2, "Server Not Responding");

    private var t: Throwable? = null

    fun setException(t: Throwable?): Error {
        this.t = t
        return this
    }

    fun getException(): Throwable? {
        return this.t
    }

}