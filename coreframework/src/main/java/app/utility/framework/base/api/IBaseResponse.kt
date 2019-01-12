package app.utility.framework.base.api

interface IBaseResponse {

    fun getContentType(vararg key: String): String?

    fun getHeaders(): Map<String, String>

    fun getStatusCode(): Int?

    fun isError(): Boolean?

    fun getBody(): Any?

    fun getErrorBody(): Any?

}