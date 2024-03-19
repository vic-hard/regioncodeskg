package com.lime.regioncodeskg.ui.navigation.plates

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.lime.regioncodeskg.utils.dpToSp

@Composable
@Preview
fun Diplomatic4DigitsPlatesPreview() {
    Diplomatic4DigitsPlates(Modifier, "1001")
}

@Composable
fun Diplomatic4DigitsPlates(modifier: Modifier, text: String) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(5.dp))
            .background(color = Color.Red)
            .width(280.dp)
            .then(modifier)
    ) {
        Row(
            modifier = Modifier
                .padding(6.dp)
                .clip(RoundedCornerShape(5.dp))
                .border(shape = RectangleShape, width = 5.dp, color = Color.White)
                .fillMaxWidth()
                .align(alignment = Alignment.CenterVertically)
        ) {
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = "HC",
                style = TextStyle(color = Color.White, fontSize = dpToSp(50.dp))
            )

            Text(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .width(120.dp),
                text = text,
                style = TextStyle(color = Color.White, fontSize = dpToSp(50.dp))
            )

            Divider(color = Color.White, modifier = Modifier
                .height(68.dp)
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
                    style = TextStyle(color = Color.White, fontSize = dpToSp(dp = 20.dp))
                )

                Divider(color = Color.White, modifier = Modifier
                    .width(50.dp)
                    .height(3.dp))

                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(start = 5.dp, end = 10.dp, bottom = 5.dp),
                    text = "28",
                    style = TextStyle(color = Color.White, fontSize = dpToSp(dp = 20.dp))
                )
            }
        }
    }
}