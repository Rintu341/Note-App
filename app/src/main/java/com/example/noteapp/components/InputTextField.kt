package com.example.noteapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun InputTextField(
    text :String,
    onChange : (String) ->Unit,
    modifier : Modifier = Modifier,
    label : String,
    shape : Shape = RoundedCornerShape(corner = CornerSize(10)),
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
    keyboardActions: KeyboardActions,

    )
{
    TextField(value = text,
        onValueChange = onChange,
        modifier = modifier.padding(start = 4.dp,end = 4.dp,top = 6.dp).fillMaxWidth(),
        label ={ Text(text = label)},
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        shape = shape
        )
}