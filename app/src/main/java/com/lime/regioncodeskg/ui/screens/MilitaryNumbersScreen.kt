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
import com.lime.regioncodeskg.ui.model.MilitaryNumbersState
import com.lime.regioncodeskg.ui.navigation.keyboards.KeyType
import com.lime.regioncodeskg.ui.navigation.keyboards.KeyboardItem
import com.lime.regioncodeskg.ui.navigation.plates.MilitaryNumbersPlates

@Composable
@Preview
fun MilitaryNumbersScreenPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.DarkGray)
    ) {
        MilitaryNumbersScreen(
            state = MilitaryNumbersState(
                selectedSymbols = listOf("К", "A"),
                combatArm = stringResource(id = R.string.ground_forces)
            ),
            onKeyboardItemClick = { _, _ -> }
        )
    }
}

@Composable
fun MilitaryNumbersScreen(
    state: MilitaryNumbersState,
    onKeyboardItemClick: (text: String, keyType: KeyType) -> Unit
) {
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
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 16.dp),
                text = stringResource(id = R.string.military_numbers),
                style = MaterialTheme.typography.headlineLarge
            )

            MilitaryNumbersPlates(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                text = state.selectedSymbols.joinToString("")
            )

            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp),
                text = stringResource(id = R.string.enter_two_letters),
                style = MaterialTheme.typography.labelLarge
            )

            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp),
                text = state.combatArm,
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
                KeyboardItem("К", KeyType.Letter, onKeyboardItemClick, 70.dp)
                KeyboardItem("А", KeyType.Letter, onKeyboardItemClick, 70.dp)
                KeyboardItem("М", KeyType.Letter, onKeyboardItemClick, 70.dp)
                KeyboardItem("Ж", KeyType.Letter, onKeyboardItemClick, 70.dp)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                KeyboardItem("У", KeyType.Letter, onKeyboardItemClick, 70.dp)
                KeyboardItem("Г", KeyType.Letter, onKeyboardItemClick, 70.dp)
                KeyboardItem("С", KeyType.Letter, onKeyboardItemClick, 70.dp)
                KeyboardItem("Ю", KeyType.Letter, onKeyboardItemClick, 70.dp)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                KeyboardItem("Б", KeyType.Letter, onKeyboardItemClick)
                KeyboardItem("Ч", KeyType.Letter, onKeyboardItemClick)
                KeyboardItem("C", KeyType.Delete, onKeyboardItemClick)
            }
        }

    }
}