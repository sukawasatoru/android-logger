package jp.tinyport.logger

class Logger {
    private val destinations = mutableSetOf<LogDestination>()

    fun addDestination(dest: LogDestination) {
        destinations.add(dest)
    }

    fun removeDestination(dest: LogDestination) {
        destinations.remove(dest)
    }

    fun removeAllDestinations() {
        destinations.clear()
    }

    fun verbose(msg: String, vararg args: Any?) {
        dispatchSend(Level.VERBOSE, msg, args)
    }

    fun debug(msg: String, vararg args: Any?) {
        dispatchSend(Level.DEBUG, msg, args)
    }

    fun info(msg: String, vararg args: Any?) {
        dispatchSend(Level.INFO, msg, args)
    }

    fun warn(msg: String, vararg args: Any?) {
        dispatchSend(Level.WARN, msg, args)
    }

    fun error(msg: String, vararg args: Any?) {
        dispatchSend(Level.ERROR, msg, args)
    }

    private fun dispatchSend(level: Level, msg: String, args: Array<out Any?>) {
        if (destinations.find { it.minLevel.priority <= level.priority } == null) {
            return
        }

        val message = if (args.isEmpty()) {
            msg
        } else {
            msg.format(*args)
        }

        for (entry in destinations) {
            if (entry.minLevel.priority <= level.priority) {
                entry.send(level, message)
            }
        }
    }

    sealed class Level(val priority: Int) {
        object VERBOSE : Level(0)
        object DEBUG : Level(1)
        object INFO : Level(2)
        object WARN : Level(3)
        object ERROR : Level(4)
    }
}
