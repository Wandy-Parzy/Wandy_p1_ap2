package com.example.wandy_p1_ap2.ui.dividir

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.wandy_p1_ap2.R
import com.example.wandy_p1_ap2.data.local.entity.DividirEntity


@Composable
fun DividirScreen(viewModel: DividirViewModel = hiltViewModel()) {
    Column(
        Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = "Diviciones", fontSize = 30.sp,
            color = Color.Blue,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        )

        Spacer(modifier = Modifier.padding(15.dp))
        DividirCuerpo(viewModel)

        Spacer(modifier = Modifier.padding(5.dp))
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    text = "Historial de resultados",
                    fontSize = 30.sp,
                    color = Color.Blue
                )
                Spacer(modifier = Modifier.width(8.dp)) // Añade espacio entre el texto y el icono
                Icon(
                    painterResource(id = R.drawable.access_time),
                    contentDescription = "Historial",
                    tint = Color.Blue,
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        Spacer(modifier = Modifier.padding(10.dp))
        val uiState by viewModel.uiState.collectAsState()
        DividirListScreen(uiState.dividirList)
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun DividirCuerpo(
    viewModel: DividirViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
            .padding(10.dp)
    ) {

        //Nombres
        OutlinedTextField(
            modifier = Modifier
                .size(470.dp, 60.dp)
                .fillMaxWidth(),
            value = viewModel.Nombres,
            onValueChange = viewModel::nombresChanged,

            label = { Text("Nombres") },
            isError = viewModel.nombresValidar.isNotBlank(),

            )
        if (viewModel.nombresValidar.isNotBlank()) {
            Text(
                text = viewModel.nombresValidar,
                color = MaterialTheme.colorScheme.error
            )
        }

        Spacer(modifier = Modifier.padding(25.dp))
        //Dividendo
        Row {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .size(470.dp, 60.dp)
                        .fillMaxWidth(),
                    value = viewModel.Dividendo,
                    onValueChange = viewModel::dividendoChanged,
                    label = { Text("Dividendo") },
                    isError = viewModel.dividendoValidar.isNotBlank(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Decimal
                    )
                )
                if (viewModel.dividendoValidar.isNotBlank()) {
                    Text(
                        text = viewModel.dividendoValidar,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
            //Divisor
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = viewModel.Divisor,
                    onValueChange = viewModel::divisorChanged,
                    label = { Text("Divisor") },
                    isError = viewModel.divisorValidar.isNotBlank(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Decimal
                    )
                )
                if (viewModel.divisorValidar.isNotBlank()) {
                    Text(
                        text = viewModel.divisorValidar,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        }

        Spacer(modifier = Modifier.padding(25.dp))
        //Cociente
        Row {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = viewModel.Cociente,
                    onValueChange = viewModel::cocienteChanged,
                    label = { Text("Cociente") },
                    isError = viewModel.cocienteValidar.isNotBlank(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Decimal
                    )
                )
                if (viewModel.cocienteValidar.isNotBlank()) {
                    Text(
                        text = viewModel.cocienteValidar,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
            //Residuo
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = viewModel.Residuo,
                    onValueChange = viewModel::residuoChanged,
                    label = { Text("Residuo") },
                    isError = viewModel.residuoValidar.isNotBlank(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Decimal
                    )
                )
                if (viewModel.residuoValidar.isNotBlank()) {
                    Text(
                        text = viewModel.residuoValidar,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        }
    }

    Spacer(modifier = Modifier.padding(31.dp))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 9.dp)
    ) {
        ExtendedFloatingActionButton(
            modifier = Modifier
                .size(470.dp, 50.dp),
            containerColor = Color.Blue,
            text = { Text("Guardar", fontSize = 26.sp, color = Color.White, modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.CenterStart)) },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Save",
                    tint = Color.White,
                    modifier = Modifier
                        .size(26.dp)
                        .wrapContentSize(Alignment.CenterStart)
                )
            },
            onClick = {
                viewModel.guardar()
            }
        )
    }
}

@Composable
private fun DividirListScreen(dividirList: List<DividirEntity>) {
    LazyColumn {
        items(dividirList) { dividir ->
            DividirRow(dividir)
        }
    }
}

@Composable
private fun DividirRow(dividir: DividirEntity) {
    val viewModel: DividirViewModel = hiltViewModel()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(Alignment.CenterVertically)
    ) {
        Divider(Modifier.fillMaxWidth())

        // Nombre
        Text(
            text = "Nombre: ${dividir.Nombres}",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Color.Gray)
        )

        // Dividendo y Divisor
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = "Dividendo: ${dividir.Dividendo }",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.weight(1f)
            )

            Spacer(
                modifier = Modifier
                    .width(8.dp)
            )

            Text(
                text = "Divisor: ${dividir.Divisor }",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Color.Gray)
        )

        // Cociente y Residuo
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = "Cociente: ${dividir.Cociente }",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.weight(1f)
            )

            Spacer(
                modifier = Modifier
                    .width(8.dp)
            )

            Text(
                text = "Residuo: ${dividir.Residuo }",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.weight(1f)
            )

            ExtendedFloatingActionButton(
                modifier = Modifier
                    .size(50.dp, 50.dp),
                containerColor = Color.Red,
                text = { Text("", fontSize = 26.sp, color = Color.White) },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = "delete",
                        tint = Color.White,
                        modifier = Modifier.size(26.dp)
                    )
                },
                onClick = {
                    viewModel.eliminar(dividir)
                }
            )
        }

        Divider(Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.padding(14.dp))
    }
}
