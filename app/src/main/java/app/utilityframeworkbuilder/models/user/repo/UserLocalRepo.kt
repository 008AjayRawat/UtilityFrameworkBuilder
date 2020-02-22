package app.utilityframeworkbuilder.models.user.repo

import app.framework.base.api.ApiCallback
import app.utilityframeworkbuilder.models.user.UserModel

class UserLocalRepo : IUserRepoContract {

    override fun createUser(requestCode: Int, model: UserModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateUser(requestCode: Int, model: UserModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUser(requestCode: Int, id: Int, callback: ApiCallback) {
        //TODO have to use Rx Java or something similar,
//        callback.onExecutorStart(requestCode)
//        callback.onExecutorStop(requestCode)
//        callback.onResponse(requestCode, null, BaseRepoResponse())
//        callback.onError(requestCode, null, null)
//        callback.onFailure(requestCode, null, Exception())
    }

    override fun getUserList(requestCode: Int, page: Int, callback: ApiCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteUser(requestCode: Int, id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}