//package com.example.myapplication22
//
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import coil.compose.rememberAsyncImagePainter
//import com.example.myapplication22.database.Student
//import com.example.myapplication22.database.StudentList
//
//@Composable
//fun StudentListScreen() {
//
//    var studentList = StudentList.studentList
//
//    LazyColumn (modifier = Modifier.fillMaxSize().padding(vertical = 90.dp)){
//
//        items(studentList.size) { item ->
//            StudentCard(student = studentList[item])
//        }
//
//    }
//}
//
//@Composable
//fun StudentCard(student: Student) {
//
//    Card(modifier = Modifier
//        .fillMaxSize()
//        .padding(horizontal = 10.dp, vertical = 5.dp),
//        shape = RoundedCornerShape(16.dp),
//        elevation = CardDefaults.cardElevation(
//            defaultElevation =  10.dp,),
//        border = BorderStroke(2.dp, Color.Black),
//        colors = CardDefaults.cardColors(
//            containerColor =  Color.White,)
//
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(18.dp)
//                .background(Color.Transparent),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.Start,
//
//            ) {
//
//            var a = student.birthDate.split(" ")
//            var mYear = a[1]
//            var mMonth = a[0]
//            var mDay = a[2]
//
//            var uriTypeConverter = UriTypeConverter()
//            var icon = (student.icon)
//            Image(
//                painter = rememberAsyncImagePainter(icon),
//                contentDescription = "Captured Image",
//                modifier = Modifier
//                    .size(200.dp)
//                    .clip(RoundedCornerShape(16.dp))
//                    .border(2.dp, Color.Gray, RoundedCornerShape(16.dp))
//            )
//            Spacer(modifier = Modifier
//                .size(10.dp)
//                .background(Color.Transparent))
//            Text(
//                modifier = Modifier.background(Color.Transparent),
//                text = "${student.name} ${student.lastName}",
//                fontSize = 20.sp,
//                color = Color.Black
//            )
//            Spacer(modifier = Modifier
//                .size(10.dp)
//                .background(Color.Transparent))
//            Text(text = "Field: ${student.field}", fontSize = 18.sp, color = Color.DarkGray,
//                modifier = Modifier.background(Color.Transparent))
//            Spacer(modifier = Modifier
//                .size(10.dp)
//                .background(Color.Transparent))
//            Text(
//                text = "Birth day: ${"$mDay/${mMonth}/$mYear"}",
//                fontSize = 18.sp,
//                color = Color.DarkGray,
//                modifier = Modifier.background(Color.Transparent)
//            )
//
//
//        }
//    }
//}
