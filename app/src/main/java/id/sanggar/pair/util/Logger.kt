package id.sanggar.pair.util

interface Logger {
    fun log(message: String)
}

class LoggerImpl : Logger {

    private val tag = "AbcXyz"

    override fun log(message: String) {
        println("%s: %s".format(tag, message))
    }
}