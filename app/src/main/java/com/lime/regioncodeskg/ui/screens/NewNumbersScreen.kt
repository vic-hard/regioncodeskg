package com.lime.regioncodeskg.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lime.regioncodeskg.R
import com.lime.regioncodeskg.ui.navigation.keyboards.KeyboardItem
import com.lime.regioncodeskg.ui.navigation.plates.NewNumbersPlates
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lime.regioncodeskg.viewmodel.NewNumbersViewModel
import com.lime.regioncodeskg.ui.model.DefineNumbersState
import com.lime.regioncodeskg.ui.navigation.keyboards.KeyType

@Composable
@Preview
fun NewNumbersScreenPreview() {
    NewNumbersScreen()
}

@Composable
fun NewNumbersScreen(viewModel: NewNumbersViewModel = viewModel()) {

    val state: DefineNumbersState by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier
            .weight(1f)
            .align(Alignment.CenterHorizontally)) {
            Text(
                modifier = Modifier.wrapContentWidth(),
                text = stringResource(id = R.string.new_numbers_title),
                style = MaterialTheme.typography.headlineLarge
            )

            NewNumbersPlates(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                text = state.selectedSymbols.joinToString(separator = "")
            )

            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp),
                text = state.regionString,
                style = MaterialTheme.typography.headlineMedium
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