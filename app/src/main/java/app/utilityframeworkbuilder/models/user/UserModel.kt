package app.utilityframeworkbuilder.models.user

import app.utilityframeworkbuilder.appUtils.AVATAR
import app.utilityframeworkbuilder.appUtils.FIRST_NAME
import app.utilityframeworkbuilder.appUtils.ID
import app.utilityframeworkbuilder.appUtils.LAST_NAME
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserModel {

    @SerializedName(ID)
    @Expose
    var id: Long = 0

    @SerializedName(FIRST_NAME)
    @Expose
    var firstName: String? = null

    @SerializedName(LAST_NAME)
    @Expose
    var lastName: String? = null

    @SerializedName(AVATAR)
    @Expose
    var avatar: String? = null

}
