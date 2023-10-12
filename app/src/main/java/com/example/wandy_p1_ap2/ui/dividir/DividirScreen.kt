package com.example.wandy_p1_ap2.ui.dividir

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
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
            text = "Registro de diviciones", fontSize = 30.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        )

        Spacer(modifier = Modifier.padding(15.dp))
        DividirCuerpo(viewModel)

        Spacer(modifier = Modifier.padding(18.dp))
        Text(
            text = "Lista de diviciones", fontSize = 30.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        )
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
    ) {

        //Nombres
        OutlinedTextField(
            modifier = Modifier
                .size(330.dp, 60.dp)
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

        Row {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                OutlinedTextField(
                    modifier = Modifier
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

    Spacer(modifier = Modifier.padding(14.dp))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        ) {

            Spacer(modifier = Modifier.padding(20.dp))
            Box()
            {
                ExtendedFloatingActionButton(
                    modifier = Modifier
                        .size(60.dp, 50.dp),
                    containerColor = Color.Green,
                    text = { Text("") },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Check,
                            contentDescription = "Save",
                            tint = Color.White
                        )
                    },
                    onClick = {
                         viewModel.guardar()
                    }
                )
            }
        }
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
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(Alignment.CenterVertically)
    ) {
        Divider(Modifier.fillMaxWidth())

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = dividir.Nombres,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.weight(1f)
            )

            Spacer(
                modifier = Modifier
                    .width(1.dp)
                    .fillMaxHeight()
                    .background(Color.Gray)
            )

            Text(
                text = String.format("$ %.2f", dividir.Dividendo),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.weight(1f)
            )

            Spacer(
                modifier = Modifier
                    .width(1.dp)
                    .fillMaxHeight()
                    .background(Color.Gray)
            )

            Text(
                text = String.format("$ %.2f", dividir.Divisor),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.weight(1f)
            )
            Spacer(
                modifier = Modifier
                    .width(1.dp)
                    .fillMaxHeight()
                    .background(Color.Gray)
            )

            Text(
                text = String.format("$ %.2f", dividir.Cociente),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.weight(1f)
            )
            Spacer(
                modifier = Modifier
                    .width(1.dp)
                    .fillMaxHeight()
                    .background(Color.Gray)
            )

            Text(
                text = String.format("$ %.2f", dividir.Residuo),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.weight(1f)
            )
        }
        Divider(Modifier.fillMaxWidth())
    }
}
