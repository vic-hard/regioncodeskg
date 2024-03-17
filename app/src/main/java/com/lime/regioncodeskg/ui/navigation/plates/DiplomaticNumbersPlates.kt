package com.lime.regioncodeskg.ui.navigation.plates

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun DiplomaticNumbersPlatesPreview() {
    DiplomaticNumbersPlates("02")
}

@Composable
fun DiplomaticNumbersPlates(text: String) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(5.dp))
            .background(color = Color.Red)
            .wrapContentSize()
    ) {
        Row(
            modifier = Modifier
                .padding(6.dp)
                .clip(RoundedCornerShape(5.dp))
                .border(shape = RectangleShape, width = 5.dp, color = Color.White)
                .wrapContentSize()
                .align(alignment = Alignment.CenterVertically)
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "D",
                style = diplomaticTextStyle
            )

            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = text,
                style = diplomaticTextStyle
            )

            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "007",
                style = diplomaticTextStyle
            )

            Divider(color = Color.White, modifier = Modifier
                .height(65.dp)
                .width(3.dp))

            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .height(65.dp)

            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(start = 5.dp, top = 5.dp, end = 10.dp),
                    text = "10",
                    style = diplomaticDateStyle
                )

                Divider(color = Color.White, modifier = Modifier
                    .width(38.dp)
                    .height(3.dp))

                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(start = 5.dp, end = 10.dp, bottom = 5.dp),
                    text = "28",
                    style = diplomaticDateStyle
                )
            }
        }
    }
}

private val diplomaticTextStyle = TextStyle(color = Color.White, fontSize = 50.sp)
private val diplomaticDateStyle = TextStyle(color = Color.White, fontSize = 20.sp)