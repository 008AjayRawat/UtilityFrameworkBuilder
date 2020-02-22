package app.framework.base.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import app.framework.base.repo.Error
import app.framework.base.repo.ExecutorState
import app.framework.base.repo.RepoCallback
import app.framework.base.response.LiveState

open class BaseRepoViewModel(application: Application) : AndroidViewModel(application), RepoCallback {

    private val observerMap: HashMap<Int, MutableLiveData<LiveState>> = HashMap()

    protected fun observerRequestCode(requestCode: Int): MutableLiveData<LiveState> {
        if (observerMap.containsKey(requestCode))
            return observerMap[requestCode]!!
        //Create new observer and return...
        val observer = MutableLiveData<LiveState>()
        observerMap[requestCode] = observer
        return observer
    }

    override fun onResponse(requestCode: Int, data: Any?) {
        if (observerMap.isNotEmpty() && observerMap.containsKey(requestCode))
            observerMap[requestCode]?.postValue(LiveState(requestCode, ExecutorState.SUCCESS, data, null))
    }

    override fun onFailure(requestCode: Int, error: Error?) {
        if (observerMap.isNotEmpty() && observerMap.containsKey(requestCode))
            observerMap[requestCode]?.postValue(LiveState(requestCode, ExecutorState.FAILED, null, error))
    }

    override fun onStateChanged(requestCode: Int, state: ExecutorState) {
        if (observerMap.isNotEmpty() && observerMap.containsKey(requestCode))
            observerMap[requestCode]?.postValue(LiveState(requestCode, state, null, null))
    }
}