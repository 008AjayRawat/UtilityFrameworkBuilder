package app.utilityframeworkbuilder.models.product

import app.utilityframeworkbuilder.appUtils.DESC
import app.utilityframeworkbuilder.appUtils.ID
import app.utilityframeworkbuilder.appUtils.NAME
import app.utilityframeworkbuilder.appUtils.PRICE
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProductModel {

    @SerializedName(ID)
    @Expose
    var id: Long = 0

    @SerializedName(NAME)
    @Expose
    var name: String? = null

    @SerializedName(PRICE)
    @Expose
    var price: String? = null

    @SerializedName(DESC)
    @Expose
    var desc: String? = null

}