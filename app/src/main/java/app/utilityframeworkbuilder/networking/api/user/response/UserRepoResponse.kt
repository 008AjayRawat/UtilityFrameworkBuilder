package app.utilityframeworkbuilder.networking.api.user.response

import app.utility.framework.base.response.BaseRepoResponse
import app.utilityframeworkbuilder.appUtils.DATA
import app.utilityframeworkbuilder.models.user.UserModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserRepoResponse : BaseRepoResponse() {

    @SerializedName(DATA)
    @Expose
    var data: UserModel? = null


}