package com.lime.regioncodeskg.ui.navigation.drawer

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.lime.regioncodeskg.R
import com.lime.regioncodeskg.ui.navigation.NavRoutes

sealed class DrawerItem(val route: String, @DrawableRes val iconResId: Int, @StringRes val titleResId: Int) {
    object NewNumbers : DrawerItem(
        NavRoutes.NewNumbers.value,
        R.drawable.ic_new_numbers_drawer24dp,
        R.string.new_numbers_title
    )

    object OldNumbers : DrawerItem(
        NavRoutes.OldNumbers.value,
        R.drawable.ic_old_numbers_drawer24dp,
        R.string.old_numbers_title
    )

    object Diplomatic : DrawerItem(
        NavRoutes.Diplomatic.value,
        R.drawable.ic_diplomatic_numbers_drawer24dp,
        R.string.diplomatic_numbers_title
    )
}