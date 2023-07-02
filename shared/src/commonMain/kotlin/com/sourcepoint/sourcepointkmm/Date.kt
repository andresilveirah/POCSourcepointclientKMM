package com.sourcepoint.sourcepointkmm

import kotlinx.datetime.*

class Date {
    fun today(): String {
        val todayDate = Clock.System.now()
        return todayDate.toString()
    }
}