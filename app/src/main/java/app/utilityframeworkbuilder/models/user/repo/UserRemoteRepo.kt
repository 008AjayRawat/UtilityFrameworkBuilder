package app.utilityframeworkbuilder.models.user.repo

import app.utility.framework.base.api.ApiExecutor
import app.utility.framework.base.api.ModelApiCallback
import app.utility.framework.base.repo.BaseRemoteRepo
import app.utilityframeworkbuilder.models.user.UserModel
import app.utilityframeworkbuilder.networking.api.user.UserApi

class UserRemoteRepo : BaseRemoteRepo(), IUserRepoContract {

    override fun createUser(requestCode: Int, model: UserModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateUser(requestCode: Int, model: UserModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteUser(requestCode: Int, id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUser(requestCode: Int, id: Int, callback: ModelApiCallback) {
        val userApi = getApiService(UserApi::class.java)
        ApiExecutor.getResponse(requestCode, userApi.getUser(1), callback)
    }

    override fun getUserList(requestCode: Int, page: Int, callback: ModelApiCallback) {
        val userApi = getApiService(UserApi::class.java)
        ApiExecutor.getResponse(requestCode, userApi.getUserList(1), callback)
    }

}