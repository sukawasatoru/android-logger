package jp.tinyport.logger

abstract class LogDestination {
    var minLevel: Logger.Level = Logger.Level.VERBOSE

    abstract fun send(level: Logger.Level, msg: String)
}
