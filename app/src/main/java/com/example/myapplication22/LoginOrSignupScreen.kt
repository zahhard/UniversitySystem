package com.example.myapplication22

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication22.ui.theme.tealGreen


@Composable
fun LoginOrSignupScreen(navController: NavController) {
    Box(
        modifier = with(Modifier) {
            fillMaxSize()
                .paint(
                    // Replace with your image id
                    painterResource(id = R.drawable.bg),
                    contentScale = ContentScale.FillBounds
                )

//                .background(
//                    brush = Brush.verticalGradient(
//                        listOf(Color.Transparent.copy(alpha = 0.2f), Color.Black.copy(alpha = 0.9f))
//                    ),
//                )
//                .blur(50.dp)

        })
    {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 10.dp, start = 10.dp, bottom = 50.dp, top = 5.dp)
                .align(Alignment.BottomCenter)
        )
        {
            Column {
                Button(onClick = {  navController.navigate("Signup") },
                    Modifier
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = tealGreen)

                        ) {
                    Text(text = "ثبت نام")

                }

                OutlinedButton(onClick = { navController.navigate("Login") },
                    Modifier.fillMaxWidth()) {
                    Text("قبلا اکانت دارم", color = tealGreen)
                }
            }
        }
    }
}