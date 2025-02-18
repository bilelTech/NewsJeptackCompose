package com.test.newsjeptackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.test.newsjeptackcompose.presentation.onboarding.OnBoardingScreen
import com.test.newsjeptackcompose.presentation.onboarding.OnBoardingViewModel
import com.test.newsjeptackcompose.ui.theme.NewsJeptackComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            NewsJeptackComposeTheme {
                val viewModel : OnBoardingViewModel = hiltViewModel()
                Surface(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
                    OnBoardingScreen(event = viewModel::onEvent)
                }
            }
        }
    }
}