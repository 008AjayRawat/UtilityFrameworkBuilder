package app.utilityframeworkbuilder.networking.api.user

import app.utilityframeworkbuilder.networking.api.user.response.UserRepoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface UserApi {


    @GET("/api/users")//?page=2
    fun getUser(@Query("id") id: Int): Call<UserRepoResponse>

    @GET("/api/users")//?page=2
    fun getUserList(@Query("page") page: Int): Call<UserRepoResponse>


}