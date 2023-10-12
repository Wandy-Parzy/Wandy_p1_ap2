package com.example.wandy_p1_ap2.ui.dividir

import DividirViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.wandy_p1_ap2.data.local.entity.DividirEntity


@Composable
fun DividirScreen(viewModel: DividirViewModel = hiltViewModel()) {

    Column(
        Modifier.fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        Spacer(modifier = Modifier.padding(50.dp))
        Text(
            text = "Registro de diviciones", fontSize = 30.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun PrestamoBody(
    viewModel: DividirViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {

        OutlinedTextField(
            modifier = Modifier
                .size(330.dp, 60.dp)
                .fillMaxWidth(),
            value = viewModel.Nombres,
            onValueChange = viewModel::nombresChanged,

            label = { Text("Nombres") },
            )
    }
}

@Composable
private fun DividirListScreen(dividirList: List<DividirEntity>) {

}
@Composable
private fun DividirRow(dividir: DividirEntity) {

}
