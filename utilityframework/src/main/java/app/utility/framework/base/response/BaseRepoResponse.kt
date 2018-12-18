package app.utility.framework.base.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class BaseRepoResponse {

    @SerializedName("code")
    @Expose
    val code: String? = null

    @SerializedName("error")
    @Expose
    val error: Boolean = false

    @SerializedName("message")
    @Expose
    val message: String? = null

}