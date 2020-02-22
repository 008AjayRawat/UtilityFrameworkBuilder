package app.framework.retrofit

import app.framework.base.api.IBaseResponse
import retrofit2.Response

class RetrofitResponse<T>(private val response: Response<T>?) : IBaseResponse {

    override fun getContentType(vararg key: String): String? {
        return if (key.isNotEmpty()) getHeaders()[key[0]] else getHeaders()["content-type"]
    }

    override fun getHeaders(): Map<String, String> {
        val map = HashMap<String, String>()
        val headers = response?.headers()
        for (i in 0 until headers!!.size()) {
            map[headers.name(i)] = headers.value(i)
        }
        return map
    }

    override fun getStatusCode(): Int? {
        return response?.code()
    }

    override fun isError(): Boolean? {
        return response?.isSuccessful?.not()
    }

    override fun getBody(): Any? {
        return response?.body()
    }

    override fun getErrorBody(): Any? {
        return response?.errorBody()
    }


}