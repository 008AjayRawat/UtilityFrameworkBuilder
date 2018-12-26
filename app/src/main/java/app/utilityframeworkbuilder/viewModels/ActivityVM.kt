package app.utilityframeworkbuilder.viewModels

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import app.utility.framework.base.response.ResponseState
import app.utility.framework.base.viewModel.BaseViewModel
import app.utilityframeworkbuilder.models.user.repo.IUserRepoContract
import app.utilityframeworkbuilder.models.user.repo.UserRepoProvider
import okhttp3.Request

class ActivityVM(application: Application) : BaseViewModel(application) {

    //TODO( need to use DI(Dependency Injection e.g Dagger))
    private var mUserRepo: IUserRepoContract = UserRepoProvider.getUerRepo()

    fun getUser(requestCode: Int): MutableLiveData<ResponseState> {
        mUserRepo.getUser(requestCode, 1, this)
        return responseState
    }

    fun getUserList(requestCode: Int): MutableLiveData<ResponseState> {
        mUserRepo.getUserList(requestCode, 1, this)
        return responseState
    }

    override fun onResponse(requestCode: Int, request: Request?, response: Any?) {
        super.onResponse(requestCode, request, response)
        responseState.postValue(ResponseState(requestCode, ResponseState.Status.SUCCESS, response, null))
    }

}