package app.utility.framework.base.fragments


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.view.View
import app.utility.framework.base.api.ApiCallback
import app.utility.framework.base.api.IBaseRequest
import app.utility.framework.base.api.IBaseResponse
import app.utility.framework.apiexecutors.retrofit.RetrofitClient
import retrofit2.Retrofit

abstract class BaseFragment : Fragment(), View.OnClickListener, ApiCallback {

    private var v: View? = null
    protected val mRetrofitInstance: Retrofit = RetrofitClient.getRetrofitInstance()


    protected fun findView(id: Int): View? {
        return v?.findViewById(id)
    }

    protected fun setOnClickListener(@IdRes vararg viewIds: Int) {
        for (i in viewIds) {
            findView(i)?.setOnClickListener(this)
        }
    }

    override fun onClick(v: View?) {}

    protected fun hideVisibility(vararg viewIds: Int) {
        for (i in viewIds) {
            findView(i)?.visibility = View.GONE
        }
    }

    protected fun showVisibility(vararg viewIds: Int) {
        for (i in viewIds) {
            findView(i)?.visibility = View.VISIBLE
        }
    }

    protected open fun showApiViewLoader(responseCode: Int) {}

    protected open fun hideAPiViewLoader(responseCode: Int) {}

    protected fun <T> getApiService(serviceName: Class<T>): T {
        return mRetrofitInstance.create(serviceName)
    }

    protected fun startNextActivity(activityClass: Class<out Activity>) {
        val i = Intent(activity, activityClass)
        startActivity(i)
    }

    protected fun startNextActivity(bundle: Bundle?, activityClass: Class<out Activity>) {
        val i = Intent(activity, activityClass)
        if (null != bundle) {
            i.putExtras(bundle)
        }
        startActivity(i)
    }

    protected fun startNextActivityAndFinishCurrent(activityClass: Class<out Activity>) {
        val i = Intent(activity, activityClass)
        startActivity(i)
        activity?.finish()
    }

    protected fun startNextActivityAndFinishCurrent(bundle: Bundle, activityClass: Class<out Activity>) {
        val i = Intent(activity, activityClass)
        i.putExtras(bundle)
        startActivity(i)
        activity?.finish()
    }

    protected fun startNextActivityForResult(activityClass: Class<out Activity>, REQUEST_CODE: Int) {
        val i = Intent(activity, activityClass)
        startActivityForResult(i, REQUEST_CODE)
    }

    protected fun startNextActivityForResult(bundle: Bundle, activityClass: Class<out Activity>, REQ_CODE: Int) {
        val i = Intent(activity, activityClass)
        i.putExtras(bundle)
        startActivityForResult(i, REQ_CODE)
    }

    override fun onResponse(requestCode: Int, request: IBaseRequest?, response: IBaseResponse?) {
    }

    override fun onFailure(requestCode: Int, request: IBaseRequest?, t: Throwable?) {
    }

    override fun onError(requestCode: Int, request: IBaseRequest?, response: IBaseResponse?) {
    }

    override fun onExecutorStart(requestCode: Int) {
    }

    override fun onExecutorStop(requestCode: Int) {
    }

}
