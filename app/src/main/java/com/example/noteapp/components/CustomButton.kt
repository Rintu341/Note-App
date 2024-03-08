package com.example.noteapp.components

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape

@Composable
fun CustomButton(value:String,
                 buttonColor:ButtonColors,
                 modifier: Modifier = Modifier,
                 textColor: Color = Color.White,
                 shape: Shape = RoundedCornerShape(corner = CornerSize(10)),
                 onClick: () -> Unit,
                 )
{
    Button(onClick = { onClick.invoke() },
        modifier = modifier,
        shape = shape,
        colors = buttonColor ) {
        Text(
            text = value,
            color = textColor
        )
    }
}