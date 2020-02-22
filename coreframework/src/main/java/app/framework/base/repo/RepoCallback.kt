package app.framework.base.repo

interface RepoCallback {

    fun onResponse(requestCode: Int, data: Any?)

    fun onFailure(requestCode: Int, error: Error?)

    fun onStateChanged(requestCode: Int, state: ExecutorState)

}