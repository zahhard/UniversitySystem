package com.example.myapplication22



import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication22.database.Student
import com.example.myapplication22.database.StudentList
import com.example.myapplication22.ui.theme.tealGreen
import com.gmail.hamedvakhide.compose_jalali_datepicker.JalaliDatePickerDialog


@ExperimentalMaterial3Api
@Composable
fun HomeScreen(navController: NavController) {

    val openDialog = remember { mutableStateOf(false) }







    var sNumber = remember { mutableStateOf("") }
    var fName = remember { mutableStateOf("") }
    var lName = remember { mutableStateOf("") }
    var field = remember { mutableStateOf("") }


    var day = remember { mutableStateOf("") }
    var month = remember { mutableStateOf("") }
    var year = remember { mutableStateOf("") }




    Box(modifier = Modifier.fillMaxSize().padding(top = 100.dp)) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(bottom = 50.dp)
                //.weight(weight = 1f, fill = false)
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Text(
                text = "Login Now ...",
                fontSize = 15.sp,
                color = tealGreen,
                modifier = Modifier.padding(8.dp)
            )

            TextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                value = sNumber.value,
                onValueChange = { sNumber.value = it },
                label = { Text("Student number", fontSize = 12.sp) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 5.dp),
                colors = TextFieldDefaults.textFieldColors(
                    errorContainerColor = Color.Red,
                    containerColor = tealGreen.copy(.2f),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent

                ),
                shape = RoundedCornerShape(30.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = null
                    )
                }
            )

            TextField(
                value = fName.value,
                onValueChange = { fName.value = it },
                label = { Text("First Name", fontSize = 12.sp) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 5.dp),
                colors = TextFieldDefaults.textFieldColors(
                    errorContainerColor = Color.Red,
                    containerColor = tealGreen.copy(.2f),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent

                ),
                shape = RoundedCornerShape(30.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = null
                    )
                }
            )


            TextField(
                value = lName.value,
                onValueChange = { lName.value = it },
                label = { Text("Last Name", fontSize = 12.sp) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 5.dp),
                colors = TextFieldDefaults.textFieldColors(
                    errorContainerColor = Color.Red,
                    containerColor = tealGreen.copy(.2f),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent

                ),
                shape = RoundedCornerShape(30.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.AccountCircle,
                        contentDescription = null
                    )
                }
            )

            TextField(
                value = field.value,
                onValueChange = { field.value = it },
                label = { Text("Field", fontSize = 12.sp) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 5.dp),
                colors = TextFieldDefaults.textFieldColors(
                    errorContainerColor = Color.Red,
                    containerColor = tealGreen.copy(.2f),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent

                ),
                shape = RoundedCornerShape(30.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = null
                    )
                }
            )
            val context = LocalContext.current
//            var birthDate = MyContent()

            Button(onClick = { openDialog.value = true }) {
                Text(text = "Open JalaliDatePicker")
            }
            JalaliDatePickerDialog(
                openDialog = openDialog,
                onSelectDay = { //it:JalaliCalendar
                    Log.d("Date", "onSelect: ${it.day} ${it.monthString} ${it.year}")
                },
                onConfirm = {
                    day.value = it.day.toString()
                    month.value = it.monthString
                    year.value = it.year.toString()
                }

            )

            Text(text = "Date : ${day.value} ${month.value} ${year.value}")
            var imgUri = CameraCaptureScreen()


            Button(
                onClick = {
                    if (fName.value.isNotEmpty() &&
                        lName.value.isNotEmpty() &&
                        field.value.isNotEmpty() &&
                        sNumber.value.isNotEmpty()) {

                        if (imgUri != null){
                            var student = Student(
                                code = sNumber.value.toInt(),
                                name = fName.value,
                                lastName = lName.value,
                                birthDate = "${day.value} ${month.value} ${year.value}",
                                field = field.value,
                                icon = imgUri

                            )


                            if (student != null) {
                                StudentList.studentList.add(student)
                            }
                            navController.navigate(Screens.StudentList.screens)

                        }


                        Toast.makeText(
                            context,
                            imgUri.toString(),
                            Toast.LENGTH_LONG
                        )
                            .show()

                        Toast.makeText(
                            context,
                            "You clicked the button.",
                            Toast.LENGTH_LONG
                        )
                            .show()

                    }

//                    val gson = Gson()
//                    val userJson = gson.toJson(student)
//
//                    // ارسال JSON به صفحه home با استفاده از createRoute
//                    navController.navigate(Screens.Setting.createRoute(userJson)) {
//                    }

                    else{
                        Toast.makeText(
                            context,
                            "fill all components.",
                            Toast.LENGTH_LONG
                        )
                            .show()
                    }
                },
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = tealGreen)
            ) {
                Text(text = "Sign up")
            }
        }
    }
}

