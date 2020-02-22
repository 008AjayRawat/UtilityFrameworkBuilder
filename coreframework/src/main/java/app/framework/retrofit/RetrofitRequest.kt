package app.framework.retrofit

import app.framework.base.api.IBaseRequest
import retrofit2.Call

class RetrofitRequest<T>(private val call: Call<T>) : IBaseRequest {

    override fun getScheme(): String {
        return call.request().url().scheme()
    }

    override fun getUrl(): String {
        return call.request().url().toString()
    }

    override fun getHost(): String {
        return call.request().url().host()
    }

    override fun getEncodedParams() {
        call.request().url().encodedQuery()
    }

    override fun getContentType(): String {
        return call.request().body()?.contentType().toString()
    }

    override fun getMethodType(): String {
        return call.request().method()
    }

    override fun getRequest(): Any? {
        return call.request()
    }

}