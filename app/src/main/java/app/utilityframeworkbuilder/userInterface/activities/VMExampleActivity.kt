package app.utilityframeworkbuilder.userInterface.activities

import android.os.Bundle
import app.framework.base.activities.BaseViewModelActivity
import app.framework.base.repo.Error
import app.framework.base.repo.ExecutorState
import app.utilityframeworkbuilder.R
import app.utilityframeworkbuilder.viewModels.ActivityViewModel

class VMExampleActivity : BaseViewModelActivity() {
    private lateinit var mVmActivity: ActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //To Use View Model...
        mVmActivity = getViewModel(ActivityViewModel::class.java)
        mVmActivity.getUser(1).observe(this, this)
        mVmActivity.getUserList(2).observe(this, this)

    }


    override fun onResponse(requestCode: Int, data: Any?) {

    }

    override fun onFailure(requestCode: Int, error: Error?) {
    }

    override fun onStateChanged(requestCode: Int, state: ExecutorState) {
    }
}
