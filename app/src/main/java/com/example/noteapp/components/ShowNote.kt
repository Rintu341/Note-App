package com.example.noteapp.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteapp.model.Note
import java.time.format.DateTimeFormatter

@Preview(showBackground = true)
@Composable
fun ShowNode(
    modifier: Modifier = Modifier,
    note : Note = Note(title = "Become a Android Developer",
            description = "Build unique projects and learn new technology"),
    onNoteClick:(Note)->Unit = {})
{
    val isClick = remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(15)),
        colors = CardDefaults.cardColors(Color(0xFF000000)),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Row(
            modifier = modifier.fillMaxWidth()
                .clickable {
                    isClick.value = !isClick.value
                },
            verticalAlignment = Alignment.CenterVertically,
        )
        {
            Column(
                modifier = Modifier
                    .padding(8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            )
            {
                Text(
                    text = note.title + ":",
                    color = Color.White,
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.titleMedium.fontSize
                    )
                )
                Text(
                    text = note.description,
                    color = Color.White,
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.titleSmall.fontSize
                    )
                )
//                Text(
//                    text = note.entryDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
//                    color = Color.White,
//                    style = TextStyle(
//                        fontSize = 10.sp
//                    )
//                )
            }
            if(isClick.value){
                Column(
                    horizontalAlignment = Alignment.End
                ) {

                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = null,
                        modifier = modifier
                            .padding(start = 30.dp,end = 10.dp)
                            .clickable {
                                onNoteClick(note)
                            },
                        tint = Color.White
                    )
                }

            }
        }
    }
}