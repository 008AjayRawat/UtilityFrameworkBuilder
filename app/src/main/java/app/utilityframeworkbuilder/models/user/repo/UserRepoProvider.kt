package app.utilityframeworkbuilder.models.user.repo

import app.utility.framework.base.repo.RepoCallback

class UserRepoProvider {
    companion object {
        fun getUerRepo(callback: RepoCallback): IUserRepoContract {
            return UserRemoteRepo(callback)
        }
    }

    //TODO this class should work as factory not as repo...
    //TODO add local, cache and server logic here accordingly...
    //TODO also need mapper file from DAO entity to Response Entity...


}