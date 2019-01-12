package app.utility.framework.base.response

import app.utility.framework.base.repo.Error
import app.utility.framework.base.repo.ExecutorState

data class LiveState(val requestCode: Int, val status: ExecutorState, val data: Any?, val error: Error?)