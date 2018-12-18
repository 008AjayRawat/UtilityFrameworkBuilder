package app.utilityframeworkbuilder.models.user.repo

import app.utility.framework.base.RepoCallback
import app.utility.framework.retrofit.RetrofitClient
import app.utilityframeworkbuilder.models.user.UserModel
import app.utilityframeworkbuilder.networking.api.user.UserApi
import app.utilityframeworkbuilder.networking.api.user.response.UserRepoResponse
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class UserRepo : IUserRepoContract {

    //TODO add local, cache and server logic here accordingly...


    override fun createUser(model: UserModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateUser(model: UserModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUser(id: Int, callback: RepoCallback) {
        when (1) {
            1 -> {
                val client = RetrofitClient.getRetrofitInstance().create(UserApi::class.java)
                client.getUser(id).enqueue(object : Callback, retrofit2.Callback<UserRepoResponse> {
                    override fun onFailure(call: Call<UserRepoResponse>, t: Throwable) {
                        callback.onFailure(t)
                    }

                    override fun onResponse(call: Call<UserRepoResponse>, response: Response<UserRepoResponse>) {
                        callback.onResponse(response.body() as UserRepoResponse)
                    }

                })
            }
        }



        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }


    override fun getUserList(page: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}