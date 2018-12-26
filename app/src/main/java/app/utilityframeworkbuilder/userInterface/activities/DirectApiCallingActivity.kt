package app.utilityframeworkbuilder.userInterface.activities

import android.os.Bundle
import android.view.View
import app.utility.framework.base.api.ApiExecutor
import app.utilityframeworkbuilder.R
import app.utilityframeworkbuilder.networking.api.user.UserApi
import app.utilityframeworkbuilder.networking.api.user.response.UserListRepoResponse
import app.utilityframeworkbuilder.networking.api.user.response.UserRepoResponse
import okhttp3.Request
import okhttp3.ResponseBody

class DirectApiCallingActivity : AppBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        To Use User API by Retrofit...
        val userApi = getApiService(UserApi::class.java)
        ApiExecutor.getResponse(2, userApi.getUser(2), this)
        ApiExecutor.getResponse(1, userApi.getUserList(1), this)
        ApiExecutor.getResponse(3, userApi.getRawUserList(1), this)

        setOnClickListener(R.id.btn)
    }


    override fun onResponse(requestCode: Int, request: Request?, response: Any?) {
        when (requestCode) {
            1 -> {
                val repoResponse: UserListRepoResponse = response as UserListRepoResponse
            }
            2 -> {
                val repoResponse: UserRepoResponse = response as UserRepoResponse
            }
            3 -> {
                val rawResponse = (response as ResponseBody).string()
            }
        }
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when (v?.id) {
//            R.id.btn -> mVmMainActivity.getUser()
        }

    }

}
