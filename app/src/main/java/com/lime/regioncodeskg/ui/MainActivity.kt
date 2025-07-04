package com.lime.regioncodeskg.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.lime.regioncodeskg.ui.navigation.RegionCodesNavDrawer
import com.lime.regioncodeskg.ui.navigation.drawer.DrawerItem
import com.lime.regioncodeskg.ui.theme.RegionCodesKgTheme
import com.lime.regioncodeskg.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RegionCodesKgTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val drawerItems = listOf(
                        DrawerItem.NewNumbers,
                        DrawerItem.OldNumbers,
                        DrawerItem.Diplomatic,
                        DrawerItem.Diplomatic4Digits,
                        DrawerItem.MilitaryNumbers
                    )
                    val navController = rememberNavController()
                    RegionCodesNavDrawer(drawerItems = drawerItems, navController = navController)
                }
            }
        }
    }
}