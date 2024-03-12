package com.example.noteapp.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.noteapp.viewModel.NoteViewModel

@Composable
fun HomeScreen(noteViewModel: NoteViewModel = viewModel())
{
    val title = remember {
        mutableStateOf("")
    }
    val desc = remember{
        mutableStateOf("")
    }
    val Notes = noteViewModel.noteList
    NoteActivity(
        notes = Notes.value,
        onAdd = {
            noteViewModel.addNote(it)
        },
        onRemove = {
            noteViewModel.removeNote(it)
        },
        title,
        desc
    )
}