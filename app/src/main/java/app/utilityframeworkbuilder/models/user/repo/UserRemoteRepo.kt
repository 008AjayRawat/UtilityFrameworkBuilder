package app.utilityframeworkbuilder.models.user.repo

import app.framework.base.api.ApiCallback
import app.framework.base.api.ApiExecutor
import app.framework.base.api.IBaseRequest
import app.framework.base.api.IBaseResponse
import app.framework.base.repo.BaseRemoteRepo
import app.framework.base.repo.Error
import app.framework.base.repo.ExecutorState
import app.framework.base.repo.RepoCallback
import app.utilityframeworkbuilder.models.user.UserModel
import app.utilityframeworkbuilder.networking.api.user.UserApi

class UserRemoteRepo(private val callback: RepoCallback) : BaseRemoteRepo(), IUserRepoContract, ApiCallback {

    override fun createUser(requestCode: Int, model: UserModel) {
    }

    override fun updateUser(requestCode: Int, model: UserModel) {
    }

    override fun deleteUser(requestCode: Int, id: Int) {
    }

    override fun getUser(requestCode: Int, id: Int, callback: RepoCallback) {
        val userApi = getApiService(UserApi::class.java)
        ApiExecutor.getResponse(requestCode, userApi.getUser(1), this)
    }


    override fun getUserList(requestCode: Int, page: Int, callback: RepoCallback) {
        val userApi = getApiService(UserApi::class.java)
        ApiExecutor.getResponse(requestCode, userApi.getUserList(1), this)
    }

    override fun onExecutorStart(requestCode: Int) {
        callback.onStateChanged(requestCode, ExecutorState.STARTED)
    }

    override fun onExecutorStop(requestCode: Int) {
        callback.onStateChanged(requestCode, ExecutorState.FINISHED)
    }

    override fun onResponse(requestCode: Int, request: IBaseRequest?, response: IBaseResponse?) {
        callback.onStateChanged(requestCode, ExecutorState.SUCCESS)
        callback.onResponse(requestCode, response?.getBody())
    }

    override fun onFailure(requestCode: Int, request: IBaseRequest?, t: Throwable?) {
        callback.onStateChanged(requestCode, ExecutorState.FAILED)
        //Do it accordingly...
        callback.onFailure(requestCode, Error.SERVER_ERROR.setException(t))
    }

    override fun onError(requestCode: Int, request: IBaseRequest?, response: IBaseResponse?) {
        callback.onStateChanged(requestCode, ExecutorState.FAILED)
        //Do it accordingly...
        callback.onFailure(requestCode, Error.UNKNOWN_ERROR)
    }

}