package app.utility.framework.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//https://stackoverflow.com/questions/34842390/how-to-setup-retrofit-with-no-baseurl
object RetrofitClient {

    //    private const val BASE_URL = "https://api.dubaiisc.ae/" //Provide base url here...
    private const val BASE_URL = "https://reqres.in/" //Provide base url here...
    private var retrofit: Retrofit? = null

    fun getRetrofitInstance(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }

        return retrofit!!
    }
}