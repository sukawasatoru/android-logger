package jp.tinyport.example.logger

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle

class MainActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        log.info("onCreate")

        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        log.info("onStart")

        super.onStart()
    }

    override fun onStop() {
        log.info("onStop")

        super.onStop()
    }
}
