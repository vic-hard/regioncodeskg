package com.lime.regioncodeskg.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lime.regioncodeskg.R
import com.lime.regioncodeskg.ui.model.DefineNumbersState
import com.lime.regioncodeskg.ui.navigation.keyboards.KeyType
import com.lime.regioncodeskg.ui.navigation.keyboards.KeyboardItem
import com.lime.regioncodeskg.ui.navigation.plates.DiplomaticNumbersPlates
import com.lime.regioncodeskg.utils.dpToSp
import com.lime.regioncodeskg.viewmodel.DiplomaticNumbersViewModel

@Composable
@Preview
fun DiplomaticNumbersScreenPreview() {
    DiplomaticNumbersScreen()
}

@Composable
fun DiplomaticNumbersScreen(viewModel: DiplomaticNumbersViewModel = viewModel()) {

    val state: DefineNumbersState by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                text = stringResource(id = R.string.diplomatic_numbers_title),
                style = MaterialTheme.typography.headlineLarge.copy(fontSize = dpToSp(dp = 32.dp)),
                textAlign = TextAlign.Center
            )

            DiplomaticNumbersPlates(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                text = state.selectedSymbols.joinToString(separator = "")
            )

            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp),
                text = stringResource(id = R.string.enter_first_two_digits),
                style = MaterialTheme.typography.labelLarge,
                textAlign = TextAlign.Center
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp),
                text = state.regionString,
                style = MaterialTheme.typography.headlineMedium.copy(fontSize = dpToSp(dp = 28.dp)),
                textAlign = TextAlign.Center,
            )

        }

        Column(modifier = Modifier.weight(1f)) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                KeyboardItem("1", KeyType.Number, viewModel::onKeyboardButtonClick)
                KeyboardItem("2", KeyType.Number, viewModel::onKeyboardButtonClick)
                KeyboardItem("3", KeyType.Number, viewModel::onKeyboardButtonClick)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                KeyboardItem("4", KeyType.Number, viewModel::onKeyboardButtonClick)
                KeyboardItem("5", KeyType.Number, viewModel::onKeyboardButtonClick)
                KeyboardItem("6", KeyType.Number, viewModel::onKeyboardButtonClick)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                KeyboardItem("7", KeyType.Number, viewModel::onKeyboardButtonClick)
                KeyboardItem("8", KeyType.Number, viewModel::onKeyboardButtonClick)
                KeyboardItem("9", KeyType.Number, viewModel::onKeyboardButtonClick)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                KeyboardItem("0", KeyType.Number, viewModel::onKeyboardButtonClick)

                KeyboardItem("C", KeyType.Delete, viewModel::onKeyboardButtonClick)
            }
        }

    }
}