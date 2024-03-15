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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lime.regioncodeskg.R
import com.lime.regioncodeskg.ui.model.OldNumbersState
import com.lime.regioncodeskg.ui.navigation.keyboards.KeyType
import com.lime.regioncodeskg.ui.navigation.keyboards.KeyboardItem
import com.lime.regioncodeskg.ui.navigation.plates.OldNumbersPlates
import com.lime.regioncodeskg.viewmodel.OldNumbersViewModel

@Composable
@Preview
fun OldNumbersScreenPreview() {
    OldNumbersScreen()
}

@Composable
fun OldNumbersScreen(viewModel: OldNumbersViewModel = viewModel()) {
    val state: OldNumbersState by viewModel.state.collectAsState()

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

            OldNumbersPlates(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                text = state.selectedSymbol
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
                KeyboardItem("A", KeyType.Letter, viewModel::onKeyboardButtonClick, 70.dp)
                KeyboardItem("B", KeyType.Letter, viewModel::onKeyboardButtonClick,  70.dp)
                KeyboardItem("C", KeyType.Letter, viewModel::onKeyboardButtonClick, 70.dp)
                KeyboardItem("E", KeyType.Letter, viewModel::onKeyboardButtonClick,  70.dp)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                KeyboardItem("F", KeyType.Letter, viewModel::onKeyboardButtonClick, 70.dp)
                KeyboardItem("D", KeyType.Letter, viewModel::onKeyboardButtonClick, 70.dp)
                KeyboardItem("I", KeyType.Letter, viewModel::onKeyboardButtonClick, 70.dp)
                KeyboardItem("N", KeyType.Letter, viewModel::onKeyboardButtonClick, 70.dp)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                KeyboardItem("H", KeyType.Letter, viewModel::onKeyboardButtonClick)
                KeyboardItem("Z", KeyType.Letter, viewModel::onKeyboardButtonClick)
                KeyboardItem("O", KeyType.Letter, viewModel::onKeyboardButtonClick)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                KeyboardItem("T", KeyType.Letter, viewModel::onKeyboardButtonClick)
                KeyboardItem("S", KeyType.Letter, viewModel::onKeyboardButtonClick)
                KeyboardItem("C", KeyType.Delete, viewModel::onKeyboardButtonClick)
            }
        }

    }
}