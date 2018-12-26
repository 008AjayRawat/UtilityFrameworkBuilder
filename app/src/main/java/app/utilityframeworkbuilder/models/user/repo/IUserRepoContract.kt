package app.utilityframeworkbuilder.models.user.repo

import app.utility.framework.base.api.ModelApiCallback
import app.utilityframeworkbuilder.models.user.UserModel

interface IUserRepoContract {

    //TODO need to be more generic....

    fun createUser(requestCode: Int, model: UserModel)

    fun updateUser(requestCode: Int, model: UserModel)

    fun getUser(requestCode: Int, id: Int, callback: ModelApiCallback)

    fun getUserList(requestCode: Int, page: Int, callback: ModelApiCallback)

    fun deleteUser(requestCode: Int, id: Int)

}