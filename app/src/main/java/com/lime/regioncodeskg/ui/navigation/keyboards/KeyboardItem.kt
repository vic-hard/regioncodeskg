package com.lime.regioncodeskg.ui.navigation.keyboards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun KeyboardItemPreview() {
    KeyboardItem(text = "1", keyType = KeyType.Number, onClick =  { _, _ -> }, width = 100.dp)
}

@Composable
fun KeyboardItem(
    text: String,
    keyType: KeyType,
    onClick: (text: String, keyType: KeyType) -> Unit,
    width: Dp = 100.dp,
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color.White)
            .size(width = width, height = 50.dp)
            .clickable { onClick(text, keyType) },
        contentAlignment = Alignment.Center
    ) {

        val textColor = when(keyType) {
            KeyType.Delete -> Color.Red
            else -> Color.Black
        }

        Text(text = text, style = MaterialTheme.typography.headlineMedium.copy(color = textColor))
    }
}