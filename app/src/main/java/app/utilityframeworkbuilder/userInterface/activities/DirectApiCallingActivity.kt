package app.utilityframeworkbuilder.userInterface.activities

import android.os.Bundle
import android.view.View
import app.utility.framework.base.api.ApiExecutor
import app.utility.framework.base.api.IBaseRequest
import app.utility.framework.base.api.IBaseResponse
import app.utilityframeworkbuilder.R
import app.utilityframeworkbuilder.appUtils.USER_LIST
import app.utilityframeworkbuilder.networking.api.user.UserApi
import app.utilityframeworkbuilder.networking.api.user.response.UserListRepoResponse
import app.utilityframeworkbuilder.networking.api.user.response.UserRepoResponse

class DirectApiCallingActivity : AppBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        To Use User API by Retrofit...
        val userApi = getApiService(UserApi::class.java)
//        ApiExecutor.getResponse(2, userApi.getUser(2), this)
        ApiExecutor.getResponse(USER_LIST, userApi.getUserList(1), this)
//        ApiExecutor.getResponse(3, userApi.getRawUserList(1), this)

        setOnClickListener(R.id.btn)
    }


    override fun onResponse(requestCode: Int, request: IBaseRequest?, response: IBaseResponse?) {
        when (requestCode) {
            USER_LIST -> {
                response?.getHeaders()
                val repoResponse: UserListRepoResponse = response?.getBody() as UserListRepoResponse
            }
            2 -> {
                val repoResponse: UserRepoResponse = response?.getBody() as UserRepoResponse
            }
            3 -> {
                val rawResponse = response?.getBody().toString()
            }
        }
    }

    override fun onFailure(requestCode: Int, request: IBaseRequest?, t: Throwable?) {
        super.onFailure(requestCode, request, t)
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when (v?.id) {
//            R.id.btn -> mVmMainActivity.getUser()
        }

    }

}
