package com.example.noteapp.data

import com.example.noteapp.model.Note

class NoteDataSource
{
    fun getNotes(): List<Note>
    {
        return listOf(
            Note(title = "Become An Android Developer",
                description = "Work Hard and  Build Unique Projects")
        )
    }
}