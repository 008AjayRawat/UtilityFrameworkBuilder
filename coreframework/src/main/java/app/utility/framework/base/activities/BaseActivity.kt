package app.utility.framework.base.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v7.app.AppCompatActivity
import android.view.View
import app.utility.framework.retrofit.RetrofitClient
import retrofit2.Retrofit

abstract class BaseActivity : AppCompatActivity(), View.OnClickListener {

    private val mRetrofitInstance: Retrofit = RetrofitClient.getRetrofitInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected fun setOnClickListener(@IdRes vararg viewIds: Int) {
        for (i in viewIds) {
            findViewById<View>(i).setOnClickListener(this)
        }
    }

    protected fun setOnClickListener(vararg views: View) {
        for (view in views) {
            view.setOnClickListener(this)
        }
    }

    override fun onClick(v: View?) {}

    protected fun hideVisibility(vararg viewIds: Int) {
        for (i in viewIds) {
            findViewById<View>(i).visibility = View.GONE
        }
    }

    protected fun showVisibility(vararg viewIds: Int) {
        for (i in viewIds) {
            findViewById<View>(i).visibility = View.VISIBLE
        }
    }

    protected fun <T> getApiService(serviceName: Class<T>): T {
        return mRetrofitInstance.create(serviceName)
    }

    protected fun clearBackStackAndStartNextActivity(activityClass: Class<out Activity>) {
        val intent = Intent(this, activityClass)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

    protected fun startNextActivity(activityClass: Class<out Activity>) {
        val i = Intent(this, activityClass)
        startActivity(i)
    }

    protected fun startNextActivity(bundle: Bundle?, activityClass: Class<out Activity>) {
        val i = Intent(this, activityClass)
        if (null != bundle) {
            i.putExtras(bundle)
        }
        startActivity(i)
    }

    protected fun startNextActivityAndFinishCurrent(activityClass: Class<out Activity>) {
        val i = Intent(this, activityClass)
        startActivity(i)
        finish()
    }

    protected fun startNextActivityAndFinishCurrent(bundle: Bundle, activityClass: Class<out Activity>) {
        val i = Intent(this, activityClass)
        i.putExtras(bundle)
        startActivity(i)
        finish()
    }

    protected fun startNextActivityForResult(activityClass: Class<out Activity>, REQUEST_CODE: Int) {
        val i = Intent(this, activityClass)
        startActivityForResult(i, REQUEST_CODE)
    }

    protected fun startNextActivityForResult(bundle: Bundle, activityClass: Class<out Activity>, REQ_CODE: Int) {
        val i = Intent(this, activityClass)
        i.putExtras(bundle)
        startActivityForResult(i, REQ_CODE)
    }

}