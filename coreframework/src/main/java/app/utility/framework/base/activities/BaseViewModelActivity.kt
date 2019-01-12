package app.utility.framework.base.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import app.utility.framework.base.repo.ExecutorState
import app.utility.framework.base.repo.RepoCallback
import app.utility.framework.base.response.LiveState


abstract class BaseViewModelActivity : BaseActivity(), RepoCallback, Observer<LiveState> {

    protected fun <T : ViewModel> getViewModel(vmName: Class<T>): T {
        return ViewModelProviders.of(this).get(vmName)
    }

    override fun onChanged(liveState: LiveState?) {
        when (liveState?.status) {
            ExecutorState.STARTED,
            ExecutorState.FINISHED -> onStateChanged(liveState.requestCode, liveState.status)
            ExecutorState.SUCCESS -> onResponse(liveState.requestCode, liveState.data)
            ExecutorState.FAILED -> onFailure(liveState.requestCode, liveState.error)
        }
    }
}
