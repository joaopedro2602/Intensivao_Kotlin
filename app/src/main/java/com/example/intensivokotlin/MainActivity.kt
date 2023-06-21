package com.example.intensivokotlin

import android.graphics.Paint.Align
import android.os.Bundle
import android.util.Log
import android.widget.GridLayout.Alignment
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.intensivokotlin.ui.theme.IntensivoKotlinTheme


import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class MainActivity : ComponentActivity() {
    private lateinit var minhaViewModelQueEuCrieiAgoraPouco: MinhaViewModelBemSimples


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        minhaViewModelQueEuCrieiAgoraPouco = ViewModelProvider(this).get(MinhaViewModelBemSimples::class.java)

        setContent {
            IntensivoKotlinTheme() {
                MainScreen(minhaViewModelQueEuCrieiAgoraPouco)
            }
        }
    }
}

@Composable
fun MainScreen(umaViewModel: MinhaViewModelBemSimples){
    var contadorNaView by remember { mutableStateOf(0) }
    //var contador: Int = 0

    val contadorProvenienteDaMinhaModelView by umaViewModel.contadorDaViewPublico.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Column() {
            Button(

                onClick = {
                    contadorNaView = contadorNaView + 1 // coisa de estudante
                    umaViewModel.incrementaContador() //coisa de prtof
                    Log.i("###### NOSSO_LOG", "Valor do contador: $contadorProvenienteDaMinhaModelView")
                }
            ) {
                Text(text = "+1")
            }
            Button(
                onClick = {
                    contadorNaView = contadorNaView - 1// coisa de estudante
                    umaViewModel.desincrementaContador() //coisa de prtof
                    Log.i("###### NOSSO_LOG", "Valor do contador: $contadorProvenienteDaMinhaModelView")
                }
            ) {
                Text(text = "-1")
            }
        }
        Text("Valor do contador controlado pela View: $contadorNaView \n" +
                "Valor do Contador controlado pela ViewModel: $contadorProvenienteDaMinhaModelView")
        Text("João Pedro Cabral    RM:22497")
    }

    Log.i("###### NOSSO_LOG", "Valor do contador: $contadorProvenienteDaMinhaModelView")
}



@Composable
fun MinhaSaudaao(
    nome: String?,
    dia: String = "dia 20/05/2023",
    modificador: Modifier
){
    Text(
        text = "Hello $nome \nHoje é $dia",
        color = Color(0xFF002060),
        modifier = modificador
    )

}


@Composable
fun Greeting(name: String, modificador: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modificador,
        color = Color(0xFF002060)
    )
}

@Preview(showBackground = true)
@Composable
fun MinhaPreview() {
    IntensivoKotlinTheme() {
        MainScreen(MinhaViewModelBemSimples())
    }
}