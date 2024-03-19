package com.lime.regioncodeskg.ui.dialogs

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.lime.regioncodeskg.R
import com.lime.regioncodeskg.utils.dpToSp

@Composable
@Preview
fun DiplomaticNumbersHintDialogPreview() {
    DiplomaticNumbersHintDialog { }
}

@Composable
fun DiplomaticNumbersHintDialog(onDismiss: () -> Unit) {
    Dialog(onDismissRequest = {
        onDismiss.invoke()
    }) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color.White
        ) {

            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                Text(
                    modifier = Modifier
                        .align(alignment = Alignment.Start)
                        .padding(16.dp),
                    text = stringResource(id = R.string.diplomatic_hint),
                    style = TextStyle(color = Color.Black, fontSize = dpToSp(dp = 22.dp))
                )

                Text(
                    modifier = Modifier
                        .align(alignment = Alignment.Start)
                        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                    text = stringResource(id = R.string.diplomatic_hint_example_first),
                    style = TextStyle(color = Color.Black, fontSize = dpToSp(dp = 22.dp))
                )

                Image(
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                    painter = painterResource(id = R.drawable.diplomatic_5digit),
                    contentDescription = "5 digits diplomatic number example"
                )

                Text(
                    modifier = Modifier
                        .align(alignment = Alignment.Start)
                        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                    text = stringResource(id = R.string.diplomatic_hint_5digits),
                    style = TextStyle(color = Color.Black, fontSize = dpToSp(dp = 22.dp))
                )

                Text(
                    modifier = Modifier
                        .align(alignment = Alignment.Start)
                        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                    text = stringResource(id = R.string.diplomatic_hint_example_second),
                    style = TextStyle(color = Color.Black, fontSize = dpToSp(dp = 22.dp))
                )

                Image(
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                    painter = painterResource(id = R.drawable.diplomatic_4digit),
                    contentDescription = "4 digits diplomatic number example"
                )
            }
        }

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, end = 8.dp)) {
            Image(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .clickable {
                        onDismiss.invoke()
                    },
                painter = painterResource(id = R.drawable.baseline_close_24dp),
                contentDescription = "close dialog"
            )
        }
    }
}