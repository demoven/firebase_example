package com.company.firebaseexample

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.company.firebaseexample.ui.screens.HomeScreen
import com.company.firebaseexample.ui.screens.signin.SignInScreen
import com.company.firebaseexample.ui.screens.signup.SignUpScreen

enum class FirebaseAppScreens(@StringRes val title: Int) {
    Home(title = R.string.home_screen_title),
    SignIn(title = R.string.signin_screen_title),
    SignUp(title = R.string.signup_screen_title)
}

@Composable
fun FirebaseApp(
    navController: NavHostController = rememberNavController(),
    mainViewModel: MainViewModel = viewModel()
) {
    val isLoggedIn by mainViewModel.isUserLoggedIn.collectAsState()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val startDestination = if (isLoggedIn) {
        FirebaseAppScreens.Home.name
    } else {
        FirebaseAppScreens.SignIn.name
    }
    val currentRoute = backStackEntry?.destination?.route
    val currentScreen = FirebaseAppScreens.valueOf(
        currentRoute ?: FirebaseAppScreens.Home.name
    )

    Scaffold (
        topBar = {
            FirebaseAppTopBar(
                currentScreen = currentScreen,
                navigateUp = {
                    navController.navigateUp()
                },
                modifier = Modifier
            )
        }
    ){ innerPadding ->
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(FirebaseAppScreens.Home.name){
                HomeScreen(
                    onLogout = {
                        mainViewModel.logout()
                    },
                    modifier = Modifier.padding(16.dp)
                )
            }
            composable(FirebaseAppScreens.SignIn.name){
                SignInScreen(
                    onNavigateToSignUp = {
                        navController.navigate(FirebaseAppScreens.SignUp.name)
                    },
                    modifier = Modifier.padding(16.dp)
                )
            }
            composable(FirebaseAppScreens.SignUp.name){
                SignUpScreen(
                    onNavigateToSignIn = {
                        navController.navigate(FirebaseAppScreens.SignIn.name)
                    },
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirebaseAppTopBar(
    currentScreen: FirebaseAppScreens,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    val screenWithoutArrowBack = listOf(
        FirebaseAppScreens.Home,
        FirebaseAppScreens.SignIn
    )
    TopAppBar(
        title = { Text(stringResource(currentScreen.title))},
        navigationIcon = {
            if (currentScreen !in screenWithoutArrowBack ) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        },
        modifier = modifier
    )
}