package app.utility.framework.base.app

import android.app.Application
import app.utility.framework.apiexecutors.retrofit.RetrofitClient
import retrofit2.Retrofit

open class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

}