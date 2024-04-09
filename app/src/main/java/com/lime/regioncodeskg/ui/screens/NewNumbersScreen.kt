package com.lime.regioncodeskg.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lime.regioncodeskg.R
import com.lime.regioncodeskg.ui.model.DefineNumbersState
import com.lime.regioncodeskg.ui.navigation.keyboards.KeyType
import com.lime.regioncodeskg.ui.navigation.keyboards.KeyboardItem
import com.lime.regioncodeskg.ui.navigation.plates.NewNumbersPlates
import com.lime.regioncodeskg.utils.dpToSp

@Composable
@Preview
fun NewNumbersScreenPreview() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.DarkGray)
    ) {
        NewNumbersScreen(
            DefineNumbersState(
                listOf("0", "1"),
                stringResource(id = R.string.bishkek)
            )
        ) { _, _ -> }
    }
}

@Composable
fun NewNumbersScreen(
    state: DefineNumbersState, onKeyboardItemClick: (text: String, keyType: KeyType) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 4.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier
            .weight(1.3f)
            .align(Alignment.CenterHorizontally)) {
            Text(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(bottom = 16.dp)
                    .align(Alignment.CenterHorizontally),
                text = stringResource(id = R.string.new_numbers_title),
                style = MaterialTheme.typography.headlineMedium.copy(fontSize = dpToSp(dp = 28.dp))
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
                style = MaterialTheme.typography.headlineMedium.copy(fontSize = dpToSp(dp = 28.dp))
            )

        }

        Column(modifier = Modifier.weight(1f)) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                KeyboardItem("1", KeyType.Number, onKeyboardItemClick)
                KeyboardItem("2", KeyType.Number, onKeyboardItemClick)
                KeyboardItem("3", KeyType.Number, onKeyboardItemClick)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                KeyboardItem("4", KeyType.Number, onKeyboardItemClick)
                KeyboardItem("5", KeyType.Number, onKeyboardItemClick)
                KeyboardItem("6", KeyType.Number, onKeyboardItemClick)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                KeyboardItem("7", KeyType.Number, onKeyboardItemClick)
                KeyboardItem("8", KeyType.Number, onKeyboardItemClick)
                KeyboardItem("9", KeyType.Number, onKeyboardItemClick)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 8.dp, end = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                KeyboardItem("0", KeyType.Number, onKeyboardItemClick)

                KeyboardItem("C", KeyType.Delete, onKeyboardItemClick)
            }
        }

    }
}