package com.lime.regioncodeskg.ui.navigation.drawer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DrawerContent(
    items: List<DrawerItem>,
    onItemClicked: (String) -> Unit
) {
    Spacer(modifier = Modifier.height(22.dp))
    items.forEach { item ->
        DrawerItemComposable(
            item = item,
            onItemClicked = { destination ->
                onItemClicked(destination)
            }
        )
    }
}