package app.utilityframeworkbuilder.networking.api.product

import app.utilityframeworkbuilder.networking.api.product.response.ProductRepoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApi {

    @GET("/api/users")//?page=2
    fun getProduct(@Query("id") id: Int): Call<ProductRepoResponse>

    @GET("/api/users")//?page=2
    fun getProductList(@Query("page") page: Int): Call<ProductRepoResponse>



}