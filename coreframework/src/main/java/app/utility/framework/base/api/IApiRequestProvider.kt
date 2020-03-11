package app.utility.framework.base.api

interface IApiRequestProvider {
    fun provideApiRequest(requestCode: Int): Any?
}