package id.sanggar.pair.util

import kotlinx.coroutines.withContext

suspend fun <T> emit(
    dispatchers: CoroutineDispatchers,
    action: () -> Unit
) {
    withContext(dispatchers.main) {
        action()
    }
}