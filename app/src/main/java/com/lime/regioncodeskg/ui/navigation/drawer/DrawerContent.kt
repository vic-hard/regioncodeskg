package com.lime.regioncodeskg.ui.navigation.drawer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DrawerContent(
    items: List<DrawerItem>,
    onItemClicked: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items.forEach { item ->
            DrawerItemComposable(
                item = item,
                onItemClicked = { destination ->
                    onItemClicked(destination)
                }
            )
        }
    }
}