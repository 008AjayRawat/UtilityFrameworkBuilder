package app.utilityframeworkbuilder.models.user.repo

class UserRepoProvider {
    companion object {
        fun getUerRepo(): IUserRepoContract {
            return UserRemoteRepo()
        }
    }

    //TODO this class should work as factory not as repo...
    //TODO add local, cache and server logic here accordingly...
    //TODO also need mapper file from DAO entity to Response Entity...


}