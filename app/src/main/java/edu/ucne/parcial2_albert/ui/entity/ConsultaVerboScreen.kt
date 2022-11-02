package edu.ucne.parcial2_albert.ui.entity

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ConsultaVerboScreen(
    viewModel: VerboViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Consulta de Verbos") }
                )
            }

        ) {
            Column(
                modifier = Modifier
                    .padding(it)
                    .padding(8.dp)
            ) {
                val lista by viewModel.uiState.collectAsState()

                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    item {
                        Row() {
                            Text(
                                text = "Id",
                                modifier = Modifier
                                    .border(width = 1.dp, color = Color.Black)
                                    .width(50.dp)
                                    .padding(8.dp)
                            )
                        }
                    }
                    items(lista.verbos) {
                        Row() {
                            Text(
                                text = it.VerboId.toString(),
                                modifier = Modifier
                                    .border(width = 1.dp, color = Color.Black)
                                    .width(50.dp)
                                    .padding(8.dp)
                            )
                            AsyncImage(
                                model = it.Imagen,
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        }
    }
}