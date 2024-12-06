package com.example.myapplication22

sealed class Screens (val screens: String){
    data object LoginOrSignup: Screens("LoginOrSignup")
    data object Signup: Screens("Signup")
    data object Login: Screens("Login")
    data object Home: Screens("Home")
    data object Setting: Screens("Setting")
    data object Profile: Screens("Profile")
    data object StudentList: Screens("StudentList")
    //    data object Setting: Screens("Setting/{userJson}") {
//        fun createRoute(userJson: String) = "Setting/$userJson"
//    }

}