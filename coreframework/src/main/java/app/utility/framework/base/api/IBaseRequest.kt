package app.utility.framework.base.api

/**
 * @author Ajay Rawat
 *
 * Use this to create Common Request Network API Client,
 * Will take care of SOC for ApiCallback Request
 *
 * Every Network Client must have to implement this IBaseRequest interface, to provide common request handler

 */
interface IBaseRequest {

    fun getScheme(): String

    fun getUrl(): String

    fun getHost(): String

    fun getEncodedParams()

    fun getContentType(): String

    fun getMethodType(): String

    fun getRequest(): Any?

}