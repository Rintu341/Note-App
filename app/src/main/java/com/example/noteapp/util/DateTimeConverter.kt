package com.example.noteapp.util

import androidx.room.TypeConverter
import java.sql.Timestamp
import java.util.Date

class DateTimeConverter {

    @TypeConverter
    fun timeStampFromDate(date: Date): Long
    {
        return date.time
    }

    @TypeConverter
    fun dateFromTimeStamp(timestamp: Long): Date?
    {
        return Date(timestamp)
    }
}