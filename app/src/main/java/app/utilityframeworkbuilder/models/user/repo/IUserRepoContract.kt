package app.utilityframeworkbuilder.models.user.repo

import app.utility.framework.base.RepoCallback
import app.utilityframeworkbuilder.models.user.UserModel

interface IUserRepoContract {

    fun createUser(model: UserModel)

    fun updateUser(model: UserModel)

    fun getUser(id: Int, callback: RepoCallback)

    fun getUserList(page: Int)


}