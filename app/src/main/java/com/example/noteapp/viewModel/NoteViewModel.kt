package com.example.noteapp.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.noteapp.data.NoteDataSource
import com.example.noteapp.model.Note

class NoteViewModel() : ViewModel() {
    private val _noteList = mutableStateListOf<Note>()
    val noteList: SnapshotStateList<Note> = _noteList

    init {
        _noteList.addAll(NoteDataSource().getNotes())
    }
    fun addNote(note:Note)
    {
        _noteList.add(note)
    }
    fun removeNote(note:Note){
        _noteList.remove(note)
    }
    fun modifyNote(note:Note)
    {
        val temp = _noteList.filter {
            it.id == note.id
        }
        temp[0].title = note.title
        temp[0].description = note.description
    }

}