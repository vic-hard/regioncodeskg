package com.lime.regioncodeskg.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lime.regioncodeskg.ui.navigation.drawer.DrawerContent
import com.lime.regioncodeskg.ui.navigation.drawer.DrawerItem
import com.lime.regioncodeskg.ui.screens.DiplomaticNumbersScreen
import com.lime.regioncodeskg.ui.screens.NewNumbersScreen
import com.lime.regioncodeskg.ui.screens.OldNumbersScreen

@Composable
fun RegionCodesNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    drawerItems: List<DrawerItem>
) {

    NavHost(
        navController = navController,
        startDestination = NavRoutes.NewNumbers.value,
        modifier = modifier
    ) {
        composable(NavRoutes.NewNumbers.value) {
            NewNumbersScreen()
        }
        composable(NavRoutes.OldNumbers.value) {
            OldNumbersScreen()
        }
        composable(NavRoutes.Diplomatic.value) {
            DiplomaticNumbersScreen()
        }
        composable(NavRoutes.Drawer.value) {
            when(it.destination.route) {
                NavRoutes.Drawer.value -> {
                    navController.popBackStack()
                }
                else -> {
                    DrawerContent(
                        items = drawerItems,
                        onItemClicked = { destination ->
                            navController.navigate(destination)
                        }
                    )
                }
            }
        }
    }

}