package com.example.myapplication22

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun StudentListScreen() {

    Box(modifier = Modifier.fillMaxSize()) {

    }

}
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
//            var icon = uriTypeConverter.toUri(student.icon)
//            Image(
//                painter = rememberAsyncImagePainter(icon),
//                contentDescription = "Captured Image",
//                modifier = Modifier
//                    .size(200.dp)
//                    .clip(RoundedCornerShape(16.dp))
//                    .border(2.dp, Color.Gray, RoundedCornerShape(16.dp))
//            )
//
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
