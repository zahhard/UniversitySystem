package com.example.myapplication22

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication22.ui.theme.coral
import com.example.myapplication22.ui.theme.ivory
import com.example.myapplication22.ui.theme.tealGreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {


    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("LoginPrefs", Context.MODE_PRIVATE)


    var username = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }
    var checked: Boolean by remember { mutableStateOf(false) }




    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xfffbe5c0))) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopCenter),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "! سلامی دوباره", fontSize = 30.sp, color = coral)
            Text(text = "خوش آمدید", fontSize = 20.sp, color = Color.DarkGray)


            TextField(
                value = username.value,
                onValueChange = { username.value = it },
                label = { Text("نام کاربری") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent, shape = RoundedCornerShape(15.dp))
                    .padding(8.dp),
                shape = RoundedCornerShape(15.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = ivory,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = tealGreen, // رنگ متن هنگام فوکوس
                    unfocusedLabelColor = Color.Gray // رنگ متن در حالت بدون فوکوس
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = null,
                        tint = tealGreen

                    )
                }
            )

            TextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text("رمز عبور") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent, shape = RoundedCornerShape(15.dp))
                    .padding(8.dp),
                shape = RoundedCornerShape(15.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = ivory,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = tealGreen, // رنگ متن هنگام فوکوس
                    unfocusedLabelColor = Color.Gray // رنگ متن در حالت بدون فوکوس
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = null,
                        tint = tealGreen

                    )
                }
            )

            Button(
                onClick = {
                    onClick(
                        navController,
                        checked,
                        username.value,
                        password.value,
                        sharedPreferences,
                        context,
                    )
                },
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = tealGreen)

            ) {
                Text(text = "ورود")

            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    "دخیره اطلاعات"
                )
                Checkbox(
                    checked = checked,
                    onCheckedChange = { checked = it }
                )
            }



            Text(
                if (checked) "ذخیره میشود" else "ذخیزهر نمیشود"
            )
        }
    }
}

fun onClick(
    navController: NavController,
    checked: Boolean,
    username: String,
    password: String,
    sharedPreferences: SharedPreferences,
    context: Context,
) {
    var isExsist = false
    /* TODO */
//    for (item in StudentList.studentList) {
//        if (password.toInt() == item.code && username == item.name) {
//            isExsist = true
//            StudentList.login = item.code
//        }
//    }
    if (isExsist){
        if (checked){
            // ذخیره در SharedPreferences
            sharedPreferences.edit()
                .putString("username", username)
                .putString("password", password)
                .apply()

            navController.navigate("Profile")
        }
        else{
            navController.navigate("Profile")
        }
    }
    else {


        Toast.makeText(
            context,
            "رمزعبور یا نام کاربری شما اشتباه است ",
            Toast.LENGTH_LONG
        )
            .show()

    }
}
