package com.example.noteapp.util

import androidx.room.TypeConverter
import java.util.UUID

class UUIDConvertor {
    @TypeConverter
    fun stringFromUUID(string :String?):UUID?
    {
        return  UUID.fromString(string)
    }

    @TypeConverter
    fun uuidFromString(uuid :UUID):String?{
        return uuid.toString()
    }
}