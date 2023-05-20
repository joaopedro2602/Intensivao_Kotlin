package com.example.interfacegrafica

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ModificadorDeTitulo(): Modifier{
    val modifier1: Modifier = Modifier
        .border(
            border = BorderStroke(
                width = 2.dp,
                brush = Brush.horizontalGradient(
                    colors = listOf(Color.Red, Color.Blue)
                )
            ),
            shape = MaterialTheme.shapes.medium
        )
        .padding(16.dp)

    return modifier1
}