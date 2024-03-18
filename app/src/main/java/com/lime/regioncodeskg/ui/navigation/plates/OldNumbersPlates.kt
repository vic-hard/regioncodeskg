package com.lime.regioncodeskg.ui.navigation.plates

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lime.regioncodeskg.R
import com.lime.regioncodeskg.utils.dpToSp

@Composable
@Preview
fun OldNumbersPlatesPreview() {
    OldNumbersPlates(Modifier, "D")
}

@Composable
fun OldNumbersPlates(modifier: Modifier, text: String) {

    Row(
        modifier = Modifier
            .wrapContentSize()
            .background(color = Color.White)
            .border(shape = RectangleShape, width = 10.dp, color = Color.Black)
            .height(140.dp)
            .width(250.dp)
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            modifier = Modifier
                .height(120.dp)
                .wrapContentWidth()
                .padding(start = 10.dp),
            painter = painterResource(id = R.drawable.flag_kyrgyzstan_vertical),
            contentDescription = "flag of Kyrgyzstan"
        )

        Text(
            modifier = Modifier
                .align(Alignment.Top)
                .wrapContentWidth()
                .wrapContentHeight()
                .padding(start = 40.dp, end = 8.dp),
            text = text,
            textAlign = TextAlign.Center,
            style = TextStyle(color = Color.Black, fontSize = dpToSp(dp = 100.dp))
        )
    }
}