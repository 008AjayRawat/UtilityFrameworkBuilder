package app.utilityframeworkbuilder.userInterface.activities

import android.arch.lifecycle.Observer
import android.os.Bundle
import app.utility.framework.base.response.ResponseState
import app.utilityframeworkbuilder.R
import app.utilityframeworkbuilder.networking.api.user.response.UserListRepoResponse
import app.utilityframeworkbuilder.networking.api.user.response.UserRepoResponse
import app.utilityframeworkbuilder.viewModels.ActivityVM

class VMExampleActivity : AppBaseActivity(), Observer<ResponseState> {

    private lateinit var mVmActivity: ActivityVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //To Use View Model...
        mVmActivity = getViewModel(ActivityVM::class.java)
//        mVmActivity.getUser(1).observe(this, this)
        mVmActivity.getUserList(2).observe(this, this)

    }

    override fun onChanged(responseState: ResponseState?) {
        when (responseState?.status) {
            ResponseState.Status.EXECUTOR_STARTED -> {
            }
            ResponseState.Status.EXECUTOR_FINISHED -> {
            }
            ResponseState.Status.SUCCESS -> {
                when (responseState.requestCode) {
                    1 -> {
                        if (responseState.data != null) {
                            val userRepoResponse: UserRepoResponse = responseState.data as UserRepoResponse
                        }
                    }
                    2 -> {
                        if (responseState.data != null) {
                            val userListRepoResponse: UserListRepoResponse = responseState.data as UserListRepoResponse
                        }
                    }
                }
            }
            ResponseState.Status.ERROR -> {
            }
        }
    }

}
