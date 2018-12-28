package app.utilityframeworkbuilder.userInterface.activities

import android.os.Bundle
import app.utility.framework.base.api.IBaseRequest
import app.utility.framework.base.api.IBaseResponse
import app.utilityframeworkbuilder.R
import app.utilityframeworkbuilder.appUtils.VM_USER_LIST
import app.utilityframeworkbuilder.networking.api.user.response.UserListRepoResponse
import app.utilityframeworkbuilder.viewModels.ActivityVM

class VMExampleActivity : AppBaseActivity() {

    private lateinit var mVmActivity: ActivityVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //To Use View Model...
        mVmActivity = getViewModel(ActivityVM::class.java)
//        mVmActivity.getUser(1).observe(this, this)
        mVmActivity.getUserList(VM_USER_LIST)

    }


    override fun onResponse(requestCode: Int, request: IBaseRequest?, response: IBaseResponse?) {
        //Note: We can handle the repo response here via ViewModel or ApiExcut
        when (requestCode) {
            VM_USER_LIST -> {
                val userRepoResponse: UserListRepoResponse = response?.getBody() as UserListRepoResponse
            }
        }
    }
}
