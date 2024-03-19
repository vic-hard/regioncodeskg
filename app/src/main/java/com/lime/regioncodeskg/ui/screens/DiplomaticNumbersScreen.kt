package com.lime.regioncodeskg.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lime.regioncodeskg.R
import com.lime.regioncodeskg.ui.dialogs.DiplomaticNumbersHintDialog
import com.lime.regioncodeskg.ui.labels.ScreenHeaderWithIcon
import com.lime.regioncodeskg.ui.model.DefineNumbersState
import com.lime.regioncodeskg.ui.navigation.keyboards.KeyType
import com.lime.regioncodeskg.ui.navigation.keyboards.KeyboardItem
import com.lime.regioncodeskg.ui.navigation.plates.DiplomaticNumbersPlates
import com.lime.regioncodeskg.utils.dpToSp

@Composable
@Preview
fun DiplomaticNumbersScreenPreview() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.DarkGray)) {
        DiplomaticNumbersScreen(
            DefineNumbersState(
                listOf("0", "2"),
                stringResource(id = R.string.usa)
            ),
            { _, _ -> },
            { }
        )
    }
}

@Composable
fun DiplomaticNumbersScreen(state: DefineNumbersState,
                            onKeyboardItemClick: (text: String, keyType: KeyType) -> Unit,
                            onToggleDialog: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (state.showDialog) {
            DiplomaticNumbersHintDialog {
                onToggleDialog.invoke()
            }
        }

        Column(modifier = Modifier.weight(1f)) {
            Row(modifier = Modifier.wrapContentWidth()) {

                ScreenHeaderWithIcon(
                    text = stringResource(id = R.string.diplomatic_numbers_title),
                    painter = if (isSystemInDarkTheme()) {
                        painterResource(id = R.drawable.ic_question_mark_white_24dp)
                    } else {
                        painterResource(id = R.drawable.ic_question_mark_black_24dp)
                    }
                ) {
                    onToggleDialog.invoke()
                }

            }

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
                KeyboardItem("1", KeyType.Number, onKeyboardItemClick)
                KeyboardItem("2", KeyType.Number, onKeyboardItemClick)
                KeyboardItem("3", KeyType.Number, onKeyboardItemClick)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
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
                    .padding(16.dp),
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
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                KeyboardItem("0", KeyType.Number, onKeyboardItemClick)

                KeyboardItem("C", KeyType.Delete, onKeyboardItemClick)
            }
        }

    }
}
