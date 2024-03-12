package com.example.noteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.noteapp.model.Note
import com.example.noteapp.util.DateTimeConverter
import com.example.noteapp.util.UUIDConvertor

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateTimeConverter::class,UUIDConvertor::class)
abstract class NoteDatabase : RoomDatabase()
{
    abstract  fun noteDao() : NoteDatabaseDao
}
