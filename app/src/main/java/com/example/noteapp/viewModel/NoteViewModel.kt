package com.example.noteapp.viewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.data.NoteDataSource
import com.example.noteapp.model.Note
import com.example.noteapp.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private  val repository: NoteRepository) : ViewModel() {
//    private val _noteList = mutableStateListOf<Note>()
//    val noteList: SnapshotStateList<Note> = _noteList
        private val _noteList = MutableStateFlow<List<Note>>(emptyList())
        val noteList = _noteList.asStateFlow()
    init {
        viewModelScope.launch (Dispatchers.IO){
            repository.getNotes().distinctUntilChanged()
                .collect{ listOfNotes ->
                    if(listOfNotes.isEmpty()){
                        Log.d("TAG", ":Empty List ")
                    }else
                    {
                        _noteList.value = listOfNotes
                    }
                }
        }
    }

     fun addNote(note:Note) =viewModelScope.launch {  repository.addNote(note)}

     fun removeNote(note: Note) = viewModelScope.launch { repository.deleteNote(note)}

     fun updateNote(note:Note) = viewModelScope.launch { repository.updateNote(note)}

     fun deleteAll() =viewModelScope.launch {  repository.deleteAll()}
//    fun addNote(note:Note)
//    {
//        _noteList.add(note)
//    }
//    fun removeNote(note:Note){
//        _noteList.remove(note)
//    }
//    fun modifyNote(note:Note)
//    {
//        val temp = _noteList.filter {
//            it.id == note.id
//        }
//        temp[0].title = note.title
//        temp[0].description = note.description
//    }

}