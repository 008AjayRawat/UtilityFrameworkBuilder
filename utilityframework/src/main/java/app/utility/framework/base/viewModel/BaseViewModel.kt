package app.utility.framework.base.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import app.utility.framework.base.api.ModelApiCallback
import app.utility.framework.base.response.ResponseState
import okhttp3.Request
import okhttp3.ResponseBody

open class BaseViewModel(application: Application) : AndroidViewModel(application), ModelApiCallback {

    protected var responseState: MutableLiveData<ResponseState> = MutableLiveData()

    override fun onResponse(requestCode: Int, request: Request?, response: Any?) {
    }

    override fun onFailure(requestCode: Int, request: Request?, t: Throwable) {
    }

    override fun onError(requestCode: Int, request: Request?, responseBody: ResponseBody?) {
    }

    override fun onExecutorStart(requestCode: Int) {
    }

    override fun onExecutorStop(requestCode: Int) {
    }


}