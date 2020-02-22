package app.utilityframeworkbuilder.viewModels

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import app.framework.base.response.LiveState
import app.framework.base.viewModel.BaseRepoViewModel
import app.utilityframeworkbuilder.models.user.repo.IUserRepoContract
import app.utilityframeworkbuilder.models.user.repo.UserRepoProvider

class ActivityViewModel(application: Application) : BaseRepoViewModel(application) {

    //TODO( need to use DI(Dependency Injection e.g Dagger))
    private var mUserRepo: IUserRepoContract = UserRepoProvider.getUerRepo(this)

    fun getUser(requestCode: Int): MutableLiveData<LiveState> {
        mUserRepo.getUser(requestCode, 1, this)
        return observerRequestCode(requestCode)
    }

    fun getUserList(requestCode: Int): MutableLiveData<LiveState> {
        return observerRequestCode(requestCode)
    }


}