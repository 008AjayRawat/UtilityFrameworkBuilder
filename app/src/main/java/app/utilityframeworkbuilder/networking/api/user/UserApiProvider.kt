package app.utilityframeworkbuilder.networking.api.user

import app.utility.framework.apiexecutors.retrofit.RetrofitExecutor
import app.utility.framework.base.api.IApiRequestProvider

class UserApiProvider : IApiRequestProvider {

    //Inject User Retrofit Api service..

    override fun provideApiRequest(requestCode: Int): Any? {
        return when (requestCode) {
            1 -> {
                val userApi = RetrofitExecutor().getApiService(UserApi::class.java)
                return userApi.getUser(2)
            }
            else -> null
        }


    }
}