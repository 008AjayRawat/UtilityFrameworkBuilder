package app.utilityframeworkbuilder.networking.api.user

import app.utilityframeworkbuilder.networking.api.user.response.UserListRepoResponse
import app.utilityframeworkbuilder.networking.api.user.response.UserRepoResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface UserApi {

    @GET("/api/users/{id}") /*/users/1*/
    fun getUser(@Path("id") id: Int): Call<UserRepoResponse>

    @GET("/api/users")  //?page=2
    fun getUserList(@Query("page") page: Int): Call<UserListRepoResponse>

    //If we need raw response without any parsing...
    @GET("/api/users")  //?page=2
    fun getRawUserList(@Query("page") page: Int): Call<ResponseBody>

}