package com.lime.regioncodeskg.ui.labels

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScreenHeaderWithIcon(
    text: String,
    painter: Painter,
    onIconClick: () -> Unit
) {
    Text(
        modifier = Modifier
            .padding(bottom = 16.dp),
        text = buildAnnotatedString {
            append(text)
            append(" ")
            appendInlineContent("inlineContent", "[icon]")
        },
        style = MaterialTheme.typography.titleMedium,
        textAlign = TextAlign.Center,
        inlineContent = createInlineContent(painter, onIconClick)
    )
}

fun createInlineContent(painter: Painter, onIconClick: () -> Unit) = mapOf(
    Pair(
        "inlineContent",
        InlineTextContent(
            Placeholder(
                width = 24.sp,
                height = 24.sp,
                placeholderVerticalAlign = PlaceholderVerticalAlign.AboveBaseline
            )
        ) {
            Image(
                modifier = Modifier.clickable {
                    onIconClick.invoke()
                },
                painter = painter,
                contentDescription = "Diplomatic numbers hint"
            )
        }
    )
)