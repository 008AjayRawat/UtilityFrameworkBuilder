package app.utilityframeworkbuilder.networking.api.product.response

import app.framework.base.response.BaseRepoResponse
import app.utilityframeworkbuilder.appUtils.DATA
import app.utilityframeworkbuilder.models.user.UserModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProductRepoResponse : BaseRepoResponse() {

    @SerializedName(DATA)
    @Expose
    var data: UserModel? = null

}