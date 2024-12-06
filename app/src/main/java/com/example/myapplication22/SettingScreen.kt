package com.example.myapplication22

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.util.Calendar


@Composable
fun SettingScreen(navController: NavController) {
//    // دریافت پارامتر userJson از arguments
//    val userJson = remember { navController.currentBackStackEntry?.arguments?.getString("userJson") }
//
//    // دسیریالایز کردن JSON به object
//    val gson = Gson()
//    val user = gson.fromJson(userJson, Student::class.java)

//    user?.let {
//        Box(modifier = Modifier.fillMaxSize()) {
//            Column(
//                modifier = Modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//
//                var mYear = it.birthDate.get(Calendar.YEAR)
//                var mMonth = it.birthDate.get(Calendar.MONTH)
//                var mDay = it.birthDate.get(Calendar.DAY_OF_MONTH)
//
//                Text(text = "Welcome, ${it.name} ${it.lastName}", fontSize = 24.sp, color = Color.Black)
//                Spacer(modifier = Modifier.size(10.dp))
//                Text(text = "Field: ${it.field}", fontSize = 18.sp, color = Color.Gray)
//                Spacer(modifier = Modifier.size(10.dp))
//                Text(text = "Birth day: ${"$mDay/${mMonth + 1}/$mYear"}", fontSize = 18.sp, color = Color.Gray)
//
//            }
//        }
//    }
}