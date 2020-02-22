package app.framework.base.repo

import app.framework.retrofit.RetrofitClient
import retrofit2.Retrofit

open class BaseRemoteRepo {

    protected val mRetrofitInstance: Retrofit = RetrofitClient.getRetrofitInstance()

    protected fun <T> getApiService(serviceName: Class<T>): T {
        return mRetrofitInstance.create(serviceName)
    }

}