package app.utilityframeworkbuilder.userInterface.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import app.utilityframeworkbuilder.R
import app.utilityframeworkbuilder.appUtils.USER_LIST
import app.utilityframeworkbuilder.networking.api.user.UserApi
import app.utilityframeworkbuilder.networking.api.user.response.UserRepoResponse
import app.utilityframeworkbuilder.viewModels.MainActivityVM
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppBaseActivity() {

    private lateinit var mVmMainActivity: MainActivityVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mVmMainActivity = getViewModel(MainActivityVM::class.java)

        //To Use User API by Retrofit...
        val userAPi = getApiService(UserApi::class.java)
        enqueueRetrofitCallback(USER_LIST, userAPi.getUserList(1))

        setOnClickListener(R.id.btn)
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when (v?.id) {
            R.id.btn -> mVmMainActivity.onBtnClicked()
        }

    }

    override fun showApiViewLoader(responseCode: Int) {
        super.showApiViewLoader(responseCode)
        when (responseCode) {
            USER_LIST -> {
            }
        }
    }

    //    @Suppress("UNCHECKED_CAST")
    override fun <T> onPostResponse(responseCode: Int, call: Call<T>, response: Response<T>) {
        when (responseCode) {
            USER_LIST -> onUserListResponse(response as Response<UserRepoResponse>)
        }
    }

    override fun <T> onPostFailure(responseCode: Int, call: Call<T>, t: Throwable) {
        super.onPostFailure(responseCode, call, t)
        Log.e("onPostFailure", t.message)
    }

    private fun onUserListResponse(response: Response<UserRepoResponse>) {
        if (response.isSuccessful)
            Log.d("onUserListResponse", response.body()?.data.toString())
    }

}
