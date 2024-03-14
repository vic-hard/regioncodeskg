package com.lime.regioncodeskg.ui.navigation.drawer

import androidx.compose.runtime.Composable

@Composable
fun DrawerContent(
    items: List<DrawerItem>,
    onItemClicked: (String) -> Unit
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