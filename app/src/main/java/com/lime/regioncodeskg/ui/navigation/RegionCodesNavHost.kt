package com.lime.regioncodeskg.ui.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lime.regioncodeskg.R
import com.lime.regioncodeskg.ui.model.DefineNumbersState
import com.lime.regioncodeskg.ui.navigation.drawer.DrawerContent
import com.lime.regioncodeskg.ui.navigation.drawer.DrawerItem
import com.lime.regioncodeskg.ui.screens.DiplomaticNumbersScreen
import com.lime.regioncodeskg.ui.screens.NewNumbersScreen
import com.lime.regioncodeskg.ui.screens.OldNumbersScreen
import com.lime.regioncodeskg.viewmodel.DiplomaticNumbersViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegionCodesNavDrawer(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    drawerItems: List<DrawerItem>
) {

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(drawerContent = {
        ModalDrawerSheet {
            DrawerContent(items = drawerItems, onItemClicked = { destination ->
                navController.navigate(destination)
                scope.launch { drawerState.close() }
            })
        }
    }, drawerState = drawerState) {
        Scaffold(modifier = modifier,topBar = {
            TopAppBar(title = {
                Text(text = stringResource(id = R.string.app_title))
            }, modifier = Modifier.fillMaxWidth(), navigationIcon = {
                IconButton(onClick = {
                    if (drawerState.isClosed) {
                        scope.launch { drawerState.open() }
                    } else {
                        scope.launch { drawerState.close() }
                    }
                }) {
                    val icon = if (drawerState.isClosed) Icons.Default.Menu else Icons.Default.Close
                    Icon(imageVector = icon, contentDescription = null)
                }
            })
        }) {
            RegionCodesNavHost(modifier = Modifier.padding(it), navController = navController)
        }
    }
}

@Composable
private fun RegionCodesNavHost(modifier: Modifier = Modifier,
                               navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.NewNumbers.value,
        modifier = modifier
    ) {
        composable(NavRoutes.NewNumbers.value) {
            NewNumbersScreen(hiltViewModel())
        }
        composable(NavRoutes.OldNumbers.value) {
            OldNumbersScreen(hiltViewModel())
        }
        composable(NavRoutes.Diplomatic.value) {
            val viewModel: DiplomaticNumbersViewModel = hiltViewModel()
            val state: DefineNumbersState by viewModel.state.collectAsState()
            DiplomaticNumbersScreen(state, viewModel::onKeyboardButtonClick, viewModel::toggleDialog)
        }
    }
}