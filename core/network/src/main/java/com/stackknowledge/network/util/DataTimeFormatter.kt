package com.stackknowledge.network.util

import android.annotation.SuppressLint
import com.stackknowledge.network.exception.NeedLoginException
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun String.toDate(): Date {
    kotlin.runCatching {
        SimpleDateFormat("yyyy-MM-dd`T`HH:mm:ss").parse(this)!!
    }.onSuccess {
        return it
    }
    throw NeedLoginException()
}

@SuppressLint("SimpleDateFormat")
fun Long.toLocalDateTime(): Date {
    return SimpleDateFormat("yyyy-MM-dd`T`HH:mm:ss").format(this).toDate()
}