package app.utilityframeworkbuilder.userInterface.activities

import android.os.Bundle
import android.view.View
import app.utility.framework.apiexecutors.retrofit.RetrofitResponse
import app.utility.framework.base.api.ApiCallback
import app.utility.framework.base.api.ApiExecutor
import app.utility.framework.base.api.IBaseRequest
import app.utility.framework.base.api.IBaseResponse
import app.utility.framework.base.repo.Error
import app.utility.framework.base.repo.ExecutorState
import app.utilityframeworkbuilder.R
import app.utilityframeworkbuilder.networking.api.user.UserApiProvider
import app.utilityframeworkbuilder.networking.api.user.response.UserRepoResponse

class DirectApiCallingActivity : AppBaseActivity() {

    override fun onResponse(requestCode: Int, data: Any?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFailure(requestCode: Int, error: Error?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStateChanged(requestCode: Int, state: ExecutorState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        ApiExecutor().getResponse(ApiExecutor.ExecutorType.RETROFIT, 1, UserApiProvider(), object : ApiCallback {
            override fun onExecutorStart(requestCode: Int) {

            }

            override fun onExecutorStop(requestCode: Int) {
            }

            override fun onResponse(requestCode: Int, request: IBaseRequest?, response: IBaseResponse?) {
                response?.getBody() as UserRepoResponse
            }

            override fun onFailure(requestCode: Int, request: IBaseRequest?, t: Throwable?) {
            }

            override fun onError(requestCode: Int, request: IBaseRequest?, response: IBaseResponse?) {
            }

        })

//        To Use User API by Retrofit...
//        val userApi = getApiService(UserApi::class.java)

//        ApiExecutor.retrofitExecutor.getResponse()


//        ApiExecutor.getResponse(2, userApi.getUser(2), this)
//        ApiExecutor.getResponse(USER_LIST, userApi.getUserList(1), this)
//        ApiExecutor.getResponse(3, userApi.getRawUserList(1), this)

//        setOnClickListener(R.id.btn)
    }


//    override fun onResponse(requestCode: Int, request: IBaseRequest?, response: IBaseResponse?) {
//        when (requestCode) {
//            USER_LIST -> {
//                response?.getHeaders()
//                val repoResponse: UserListRepoResponse = response?.getBody() as UserListRepoResponse
//            }
//            2 -> {
//                val repoResponse: UserRepoResponse = response?.getBody() as UserRepoResponse
//            }
//            3 -> {
//                val rawResponse = response?.getBody().toString()
//            }
//        }
//    }
//
//    override fun onFailure(requestCode: Int, request: IBaseRequest?, t: Throwable?) {
//        super.onFailure(requestCode, request, t)
//    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when (v?.id) {
//            R.id.btn -> mVmMainActivity.getUser()
        }

    }

}
