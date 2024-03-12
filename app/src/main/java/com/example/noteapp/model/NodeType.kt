package com.example.noteapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

@Entity(tableName = "note_table")
data class Note(
    @PrimaryKey
    val id:UUID = UUID.randomUUID(),

    @ColumnInfo(name = "note_title")
    var title: String,

    @ColumnInfo(name = "note_description")
    var description : String,

    @ColumnInfo(name = "note_entry_date")
    val entryDate : Date = Date.from(Instant.now())
)
