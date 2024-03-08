package com.example.noteapp.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.noteapp.model.Note

@Composable
fun HomeScreen()
{
    val noteList = remember {
        mutableStateListOf<Note>()
    }
    val title = remember {
        mutableStateOf("")
    }
    val desc = remember{
        mutableStateOf("")
    }
    NoteActivity(
        notes = noteList,
        onAdd = {
            noteList.add(it)
        },
        onRemove = {
            noteList.remove(it)
        },
        title,
        desc
    )
}