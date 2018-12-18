package app.utilityframeworkbuilder.viewModels

import android.arch.lifecycle.ViewModel
import app.utility.framework.base.RepoCallback
import app.utility.framework.base.response.BaseRepoResponse
import app.utilityframeworkbuilder.models.user.repo.IUserRepoContract
import app.utilityframeworkbuilder.models.user.repo.UserRepo

class MainActivityVM : ViewModel() {

    private var mUserRepo: IUserRepoContract = UserRepo() //TODO need to use DI(Dependency Injection e.g Dagger)


    fun onBtnClicked() {
        //TODO can call service in android using repository pattern...
        mUserRepo.getUser(1, object : RepoCallback {
            override fun onResponse(response: BaseRepoResponse) {
                //TODO
            }

            override fun onFailure(t: Throwable) {
            }
        })
    }

}