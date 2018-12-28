package app.utility.framework.base.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import app.utility.framework.base.api.IBaseRequest
import app.utility.framework.base.api.IBaseResponse
import app.utility.framework.base.api.ModelApiCallback
import app.utility.framework.base.response.ResponseState

open class BaseViewModel(application: Application) : AndroidViewModel(application), ModelApiCallback {

    protected var responseState: MutableLiveData<ResponseState> = MutableLiveData()


    override fun onResponse(requestCode: Int, request: IBaseRequest?, response: IBaseResponse?) {
        responseState.postValue(ResponseState(requestCode, ResponseState.Status.SUCCESS, request, response, null))
    }

    override fun onFailure(requestCode: Int, request: IBaseRequest?, t: Throwable?) {
        responseState.postValue(ResponseState(requestCode, ResponseState.Status.ERROR, request, null, t))
    }

    override fun onError(requestCode: Int, request: IBaseRequest?, response: IBaseResponse?) {
        responseState.postValue(ResponseState(requestCode, ResponseState.Status.ERROR, request, response, null))
    }

    override fun onExecutorStart(requestCode: Int) {
        responseState.postValue(ResponseState(requestCode, ResponseState.Status.EXECUTOR_STARTED, null, null, null))
    }

    override fun onExecutorStop(requestCode: Int) {
        responseState.postValue(ResponseState(requestCode, ResponseState.Status.EXECUTOR_FINISHED, null, null, null))
    }


}