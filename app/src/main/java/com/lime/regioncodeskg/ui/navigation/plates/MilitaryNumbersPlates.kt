package com.lime.regioncodeskg.ui.navigation.plates

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lime.regioncodeskg.R
import com.lime.regioncodeskg.utils.dpToSp

@Composable
@Preview
fun MilitaryNumbersPlatesPreview() {
    MilitaryNumbersPlates(Modifier, "КМ")
}

@Composable
fun MilitaryNumbersPlates(modifier: Modifier, text: String) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(5.dp))
            .background(color = Color.Black)
            .width(290.dp)
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
                text = "8925",
                style = TextStyle(color = Color.White, fontSize = dpToSp(50.dp))
            )

            Text(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .width(95.dp),
                text = text,
                style = TextStyle(color = Color.White, fontSize = dpToSp(50.dp))
            )

            Image(
                modifier = Modifier.align(alignment = Alignment.CenterVertically).size(24.dp),
                painter = painterResource(id = R.drawable.ic_star_white_24dp),
                contentDescription = "military plates star image"
            )
        }
    }
}