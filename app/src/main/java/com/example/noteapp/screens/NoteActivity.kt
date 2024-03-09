package com.example.noteapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.noteapp.R
import com.example.noteapp.components.CustomButton
import com.example.noteapp.components.InputTextField
import com.example.noteapp.components.ShowNode
import com.example.noteapp.model.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteActivity(
    notes: SnapshotStateList<Note>,
    onAdd:(Note)-> Unit = {},
    onRemove:(Note) ->Unit ={},
    title: MutableState<String>,
    desc: MutableState<String>
    )
{

    val isOpen = remember {
        mutableStateOf(false)
    }
    Scaffold (
            topBar = {
                TopAppBar(
                    title = { Text(text = stringResource(R.string.app_name))},
                    actions = {
                        Icon(imageVector = Icons.Filled.List, contentDescription = "list")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors =  TopAppBarDefaults.topAppBarColors(Color(0xFF9379DB))
                )
            },
            floatingActionButton = {
                   FloatingActionButton(onClick = {
                       isOpen.value = true
                   },
                       elevation = FloatingActionButtonDefaults.elevation(10.dp)) {
                       Icon(imageVector = Icons.Filled.Add, contentDescription = null)
                   }
            }
    ) { paddingValue ->
        Column(
            modifier = Modifier.padding(paddingValue)
        ) {
            MainContent(isOpen, title, desc, onAdd)
            Divider(modifier = Modifier.height(2.dp))
            LazyColumn {
                items(notes) { note ->
                    ShowNode(note = note,
                        onNoteClick = {
                            onRemove(it)
                        })
                }
            }

        }
    }
    }

@Composable
private fun MainContent(
    isOpen: MutableState<Boolean>,
    title: MutableState<String>,
    desc: MutableState<String>,
    onAdd: (Note) -> Unit
) {
    if (isOpen.value) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {

            GetNoteField(title, desc)
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                CustomButton(value = "Cancel",
                    buttonColor = ButtonDefaults.buttonColors(Color(0xFF000000)),
                    shape = RoundedCornerShape(corner = CornerSize(25)),
                    onClick = {
                        isOpen.value = false
                        title.value = ""
                        desc.value = ""
                    }
                )
                Spacer(modifier = Modifier.width(20.dp))
                CustomButton(value = "Save",
                    buttonColor = ButtonDefaults.buttonColors(Color(0xFF7BAC42)),
                    shape = RoundedCornerShape(corner = CornerSize(25)),
                    onClick = {
                        if (title.value.isNotEmpty() && desc.value.isNotEmpty()) {
                            //Add
                            onAdd(Note(title = title.value, description = desc.value))
                            title.value = ""
                            desc.value = ""
                            isOpen.value = false
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun GetNoteField(
    title: MutableState<String>,
    desc: MutableState<String>
) {
    Column(
        modifier = Modifier.padding(top = 28.dp, bottom = 30.dp),
    ) {
        InputTextField(text = title.value,
            onChange = {
                if (it.all { char ->
                        char.isLetter() || char.isWhitespace()
                    }) {
                    title.value = it
                }
            },
            label = "Enter title",
            keyboardActions = KeyboardActions(
                onNext = {///TODO
                }
            )
        )
        Spacer(modifier = Modifier.height(12.dp))
        InputTextField(text = desc.value,
            onChange = {
                if (it.all { char ->
                        char.isLetter() || char.isWhitespace()
                    }) {
                    desc.value = it
                }
            },
            label = "Enter description",
            keyboardActions = KeyboardActions(
                onNext = {///TODO
                }
            )
        )
    }
}