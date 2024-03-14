package com.lime.regioncodeskg.ui.navigation.drawer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp

@Composable
fun DrawerItemComposable(
    item: DrawerItem,
    onItemClicked: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClicked(item.route) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = ImageVector.vectorResource(item.iconResId), contentDescription = null)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = stringResource(id = item.titleResId), modifier = Modifier.wrapContentWidth())
    }
}