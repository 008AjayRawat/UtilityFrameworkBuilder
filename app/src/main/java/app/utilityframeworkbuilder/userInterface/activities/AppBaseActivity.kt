package app.utilityframeworkbuilder.userInterface.activities

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import app.utility.framework.base.activities.BaseActivity

abstract class AppBaseActivity : BaseActivity() {

    protected fun <T : ViewModel> getViewModel(vmName: Class<T>): T {
        return ViewModelProviders.of(this).get(vmName)
    }

}