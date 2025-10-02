package com.lime.regioncodeskg.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.rememberNavController
import com.google.android.play.core.review.ReviewManager
import com.lime.regioncodeskg.ui.navigation.RegionCodesNavDrawer
import com.lime.regioncodeskg.ui.navigation.drawer.DrawerItem
import com.lime.regioncodeskg.ui.theme.RegionCodesKgTheme
import com.lime.regioncodeskg.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    @Inject
    lateinit var reviewManager: ReviewManager

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
        observeReviewTrigger()
    }

    private fun observeReviewTrigger() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.reviewTrigger.collect {
                    showInAppReviewDialog()
                }
            }
        }
    }

    private fun showInAppReviewDialog() {
        reviewManager.requestReviewFlow().addOnCompleteListener {
            if (it.isSuccessful) {
                reviewManager.launchReviewFlow(this, it.result)
            }
        }
    }

}