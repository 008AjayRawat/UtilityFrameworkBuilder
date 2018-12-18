package app.utility.framework.base

import app.utility.framework.base.response.BaseRepoResponse

interface RepoCallback {

    fun onResponse(response: BaseRepoResponse)

    fun onFailure(t: Throwable)

}