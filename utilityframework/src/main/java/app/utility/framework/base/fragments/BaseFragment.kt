package app.utility.framework.base.fragments


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.view.View
import app.utility.framework.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class BaseFragment : Fragment(), View.OnClickListener {

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

    protected fun <T> enqueueRetrofitCallback(responseCode: Int, call: Call<T>) {
        showApiViewLoader(responseCode)
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                hideAPiViewLoader(responseCode)
                onPostResponse(responseCode, call, response)
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                hideAPiViewLoader(responseCode)
                onPostFailure(responseCode, call, t)
            }
        })
    }

    protected open fun <T> onPostResponse(responseCode: Int, call: Call<T>, response: Response<T>) {

    }

    protected open fun <T> onPostFailure(responseCode: Int, call: Call<T>, t: Throwable) {

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


}
