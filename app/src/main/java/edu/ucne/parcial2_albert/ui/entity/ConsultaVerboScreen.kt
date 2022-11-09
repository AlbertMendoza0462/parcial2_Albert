package edu.ucne.parcial2_albert.ui.entity

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
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
                    .padding(8.dp)
            ) {
                val lista by viewModel.uiState.collectAsState()

                Text(text = lista.error)
                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    items(lista.verbos) {
                        Row(
                            modifier = Modifier.padding(15.dp)
                        ) {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                elevation = 10.dp
                            ) {
                                Column(
                                    modifier = Modifier.padding(15.dp)
                                ) {
                                    Text(text = "Verbo: " + it.Verbo)
                                    Text(text = "Categoria: " + it.Categoria)
                                    Text(text = "Nivel: " + it.Nivel)
                                    Row(
                                        modifier = Modifier.align(Alignment.CenterHorizontally)
                                    ) {
                                        AsyncImage(
                                            model = it.Imagen,
                                            contentDescription = it.Verbo,
                                            modifier = Modifier.height(200.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}