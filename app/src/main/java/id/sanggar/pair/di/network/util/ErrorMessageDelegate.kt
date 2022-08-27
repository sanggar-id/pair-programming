package id.sanggar.pair.di.network.util

import android.content.Context
import id.sanggar.pair.R

interface ErrorMessageDelegate {
    fun ioException(): String
    fun httpException(): String
}

class ErrorMessage constructor(
    private val context: Context
): ErrorMessageDelegate {
    override fun ioException(): String {
        return context.getString(R.string.message_network_common_time_out)
    }

    override fun httpException(): String {
        return context.getString(R.string.message_network_common_something_wrong)
    }
}