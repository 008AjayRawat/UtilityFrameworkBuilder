package app.utilityframeworkbuilder.networking.api.user.response

import app.framework.base.response.BaseRepoResponse
import app.utilityframeworkbuilder.appUtils.DATA
import app.utilityframeworkbuilder.models.user.UserModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserListRepoResponse : BaseRepoResponse() {

    @SerializedName(DATA)
    @Expose
    var data: List<UserModel>? = null

}