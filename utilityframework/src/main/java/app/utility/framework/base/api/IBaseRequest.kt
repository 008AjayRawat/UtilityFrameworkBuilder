package app.utility.framework.base.api

interface IBaseRequest {

    //TODO Use this to create Independent Network API Client,
    //TODO Will take care of SOC for ModelApiCallback Request.....
    //TODO Every Network Client must have to implement this IBaseRequest interface, to provide common request handler..

    fun getStatusCode()

    fun getUrl()

    fun getParam()

    fun getMethodType()
}