package com.lime.regioncodeskg.ui.navigation.plates

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lime.regioncodeskg.R

@Composable
@Preview
fun NewNumbersPlatesPreview() {
    NewNumbersPlates(Modifier, "01")
}

@Composable
fun NewNumbersPlates(modifier: Modifier, text: String) {

    Column(
        modifier = Modifier
            .wrapContentSize()
            .background(color = Color.White)
            .border(shape = RectangleShape, width = 10.dp, color = Color.Black)
            .then(modifier),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier
                .wrapContentSize()
                .padding(start = 8.dp, end = 8.dp),
            text = text,
            textAlign = TextAlign.Center,
            style = TextStyle(color = Color.Black, fontSize = 120.sp)
        )

        Row(modifier = Modifier
            .wrapContentSize()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {

            Image(
                modifier = Modifier.height(50.dp).width(100.dp),
                painter = painterResource(id = R.drawable.flag_kyrgyzstan),
                contentDescription = "flag of Kyrgyzstan"
            )

            Text(
                text = stringResource(id = R.string.kg),
                style = TextStyle(color = Color.Black, fontSize = 50.sp)
            )

        }

    }
}