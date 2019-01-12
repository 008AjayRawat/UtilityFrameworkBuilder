package app.utilityframeworkbuilder.userInterface.activities

import android.arch.lifecycle.AndroidViewModel
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class TestActivity<V : AndroidViewModel> : AppCompatActivity() {

    protected lateinit var v: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    abstract fun <V> getViewModel(vmName: Class<V>): V


}
