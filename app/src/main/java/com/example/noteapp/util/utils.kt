package com.example.noteapp.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun formatDate(time : Long):String
{
    val date = Date(time)
    val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    return format.format(date)
}