package pl.skamycki.find3.app.infrastructure

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlin.coroutines.experimental.CoroutineContext

class AppExecutors(
        val ui: CoroutineContext = UI,
        val disk: CoroutineContext = CommonPool,
        val network: CoroutineContext = CommonPool
)
