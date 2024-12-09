package com.example.canastas

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.canastas.ui.theme.CanastasTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: MainViewModel by viewModels()
            CanastasTheme {
                Scaffold (
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Canastas") }
                        )
                    },
                    content = { paddingValues ->
                        Modifier.fillMaxSize()
                        Column(
                            Modifier.padding(paddingValues)
                        ){
                            Canastas(viewModel)
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun Canastas(viewModel: MainViewModel){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ){
        Nosotros(viewModel)
        Ellos(viewModel)
        Salir()
    }
}

@Composable
fun Nosotros(viewModel: MainViewModel){
    Column (
        modifier = Modifier
            .padding(15.dp)
            .background(color = Color.Green)
            .border(width = 2.dp, color = Color.Black)
    ){
        Text(
            modifier = Modifier
                .padding(start = 12.dp, top = 15.dp, bottom = 15.dp),
            text = "NOSOTROS   ",
            fontWeight = FontWeight.Bold
        )
        OutlinedButton(
            onClick = {
                viewModel.contadorNosotros += 1
            },
            border = BorderStroke(2.dp, Color.Black),
        ) {
            Text(text = "1 punto")
        }
        OutlinedButton(
            onClick = {
                viewModel.contadorNosotros += 2
            },
            border = BorderStroke(2.dp, Color.Black),
        ) {
            Text(text = "2 puntos")
        }
        OutlinedButton(
            onClick = {
                viewModel.contadorNosotros += 3
            },
            border = BorderStroke(2.dp, Color.Black),
        ) {
            Text(text = "3 puntos")
        }
        Text(
            modifier = Modifier
                .padding(start = 35.dp, top = 25.dp, bottom = 15.dp),
            text = "${viewModel.contadorNosotros}",
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun Ellos(viewModel: MainViewModel){
    Column (
        modifier = Modifier
            .padding(15.dp)
            .background(color = Color.Red)
            .border(width = 2.dp, color = Color.Black)
    ){
        Text(
            modifier = Modifier
                .padding(start = 12.dp, top = 15.dp, bottom = 15.dp),
            text = "ELLOS",
            fontWeight = FontWeight.Bold
        )
        OutlinedButton(
            onClick = {
                viewModel.contadorEllos += 1
            },
            border = BorderStroke(2.dp, Color.Black),
        ) {
            Text(text = "1 punto")
        }
        OutlinedButton(
            onClick = {
                viewModel.contadorEllos += 2
            },
            border = BorderStroke(2.dp, Color.Black),
        ) {
            Text(text = "2 puntos")
        }
        OutlinedButton(
            onClick = {
                viewModel.contadorEllos += 3
            },
            border = BorderStroke(2.dp, Color.Black),
        ) {
            Text(text = "3 puntos")
        }
        Text(
            modifier = Modifier
                .padding(start = 35.dp, top = 25.dp, bottom = 15.dp),
            text = "${viewModel.contadorEllos}",
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun Salir(){
    val activity = (LocalContext.current as? Activity)
    OutlinedButton(
        onClick = {
            activity?.finish()
        },
        border = BorderStroke(2.dp, Color.Black),
    ) {
        Text(text = "Salir")
    }
}