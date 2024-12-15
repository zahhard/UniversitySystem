package com.example.myapplication22

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication22.ui.theme.tealGreen
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavDrawer() {
    val navigationController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val context = LocalContext.current.applicationContext
    val isUsernameSaved = isDataStored(context, "username")




    // حالت برای نگه‌داری وضعیت صفحه فعلی
    val isHomeScreen = remember { mutableStateOf(true) }

    ModalNavigationDrawer(
        gesturesEnabled = true,
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Box(
                    modifier = Modifier
                        .background(tealGreen)
                        .height(150.dp)
                ) {
                    Text(text = "")
                }
                Divider()
                NavigationDrawerItem(
                    { Text(text = "Home", color = tealGreen) },
                    selected = isHomeScreen.value,
                    icon = {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "home",
                                tint = tealGreen
                            )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Home.screens) {
                            popUpTo(0)
                        }
                        isHomeScreen.value = true // تغییر به حالت صفحه Home
                    })
                NavigationDrawerItem(
                    { Text(text = "Setting", color = tealGreen) },
                    selected = !isHomeScreen.value,
                    icon = {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = "Setting",
                                tint = tealGreen
                            )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Setting.screens) {
                            popUpTo(0)
                        }
                        isHomeScreen.value = false // تغییر به حالت صفحات دیگر
                    })
                NavigationDrawerItem(
                    { Text(text = "Profile", color = tealGreen) },
                    selected = !isHomeScreen.value,
                    icon = {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = "Profile",
                                tint = tealGreen
                            )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Profile.screens) {
                            popUpTo(0)
                        }
                        isHomeScreen.value = false // تغییر به حالت صفحات دیگر
                    })


            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "My Class App") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = tealGreen,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    ),
                    navigationIcon = {
                        if (isHomeScreen.value) {
                            // آیکون منو برای صفحه Home
                            IconButton(onClick = {
                                coroutineScope.launch { drawerState.open() }
                            }) {
//                                    Icon(Icons.Rounded.Menu, contentDescription = "MenuButton")
                            }
                        } else {
                            // دکمه بازگشت برای صفحات دیگر
                            IconButton(onClick = {
                                navigationController.navigate(Screens.Home.screens) {
                                    popUpTo(Screens.Home.screens)
                                }
                                isHomeScreen.value = true // بازگشت به صفحه Home
                            }) {
//                                    Icon(Icons.Default.ArrowBack, contentDescription = "BackButton")
                            }
                        }
                    }
                )
            }
        ) {
            NavHost(
                navController = navigationController,
                startDestination = Screens.Splash.screens
            ) {
                composable(Screens.Login.screens) {
                    LoginScreen(navigationController)
                }
                composable(Screens.Splash.screens) {
                    SplashScreen(navController = navigationController)
                }
                composable(Screens.Signup.screens) {

                    SignUpScreen(navController = navigationController)
                }
                composable(Screens.LoginOrSignup.screens) {
                    LoginOrSignupScreen(navigationController)
                }
                composable(Screens.Home.screens) {
                    HomeScreen(navigationController)
                    isHomeScreen.value = true // در صفحه Home
                }
                composable(Screens.StudentList.screens) {
                    StudentListScreenn(navigationController)
                }
                composable(Screens.Profile.screens) {
                    ProfileScreen()
                    isHomeScreen.value = false // در صفحات دیگر
                }
                composable(Screens.Setting.screens) {
                    SettingScreen(navigationController)
                    isHomeScreen.value = false // در صفحات دیگر
                }
            }


            if (isUsernameSaved) {
                navigationController.navigate("Profile")
                // Toast.makeText(context, "Username exists in SharedPreferences", Toast.LENGTH_SHORT).show()
            } else {
                // Toast.makeText(context, "No Username found", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

fun isDataStored(context: Context, key: String): Boolean {
    // دریافت SharedPreferences
    val sharedPreferences = context.getSharedPreferences("LoginPrefs", Context.MODE_PRIVATE)
    // بررسی اینکه آیا کلید مورد نظر وجود دارد
    return sharedPreferences.contains(key)
}

