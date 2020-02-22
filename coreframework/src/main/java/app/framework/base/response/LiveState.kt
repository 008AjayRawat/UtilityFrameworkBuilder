package app.framework.base.response

import app.framework.base.repo.Error
import app.framework.base.repo.ExecutorState

data class LiveState(val requestCode: Int, val status: ExecutorState, val data: Any?, val error: Error?)