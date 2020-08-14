package jp.tinyport.logger

import android.util.Log

class ConsoleLogDestination(private val tag: String) : LogDestination() {
    override fun send(level: Logger.Level, msg: String) {
        when (level) {
            Logger.Level.VERBOSE -> Log.v(tag, msg)
            Logger.Level.DEBUG -> Log.d(tag, msg)
            Logger.Level.INFO -> Log.i(tag, msg)
            Logger.Level.WARN -> Log.w(tag, msg)
            Logger.Level.ERROR -> Log.e(tag, msg)
        }.let { }
    }
}
