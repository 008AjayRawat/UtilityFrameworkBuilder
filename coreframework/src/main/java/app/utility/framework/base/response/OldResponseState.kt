package app.utility.framework.base.response

/**
 * Created by Ajay Rawat on 07-Mar-18.
 */

//TODO add request type in status also....
class OldResponseState<out T>(val status: Status, val data: T?, val exception: Exception?) {
    enum class Status {
        SUCCESS, ERROR, DOWNLOADING, UPLOADING
    }

    companion object {
        fun <T> success(data: T): OldResponseState<T> {
            return OldResponseState(Status.SUCCESS, data, null)
        }

        fun <T> error(exception: Exception): OldResponseState<T> {
            return OldResponseState(Status.ERROR, null, exception)
        }

        fun <T> downloading(data: T): OldResponseState<T> {
            return OldResponseState(Status.DOWNLOADING, data, null)
        }

        fun <T> uploading(data: T): OldResponseState<T> {
            return OldResponseState(Status.UPLOADING, data, null)
        }

    }

}