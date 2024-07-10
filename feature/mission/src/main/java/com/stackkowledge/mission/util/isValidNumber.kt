package com.stackkowledge.mission.util

fun String.isValidNumber(): Boolean {
    return try {
        this.toInt()
        true
    } catch (e: NumberFormatException) {
        false
    }
}