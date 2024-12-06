package com.example.myapplication22

import android.content.Context
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Science
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication22.ui.theme.tealGreen
import coil.compose.rememberAsyncImagePainter
import com.example.myapplication22.database.StudentList


@Composable
fun ProfileScreen() {

    var savedUsername = remember { mutableStateOf("") }


    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("LoginPrefs", Context.MODE_PRIVATE)
    savedUsername.value = sharedPreferences.getString("username", "").toString()
    val savedPassword = sharedPreferences.getString("password", null)
    var uri = remember { mutableStateOf(Uri.EMPTY) }
    var uriTypeConverter = UriTypeConverter()


    for (item in StudentList.studentList) {
        if (savedPassword != "") {
            if (savedPassword != null) {
                if (savedPassword.toInt() == item.code) {
                    uri.value = item.icon
                }
            }else if (StudentList.login == item.code){
                uri.value = item.icon
                savedUsername.value = item.name + " " + item.lastName
            }
        }

    }


    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(end = 16.dp, start = 16.dp, bottom = 60.dp, top = 100.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
            ) {

            // عنوان بالا
            Text(
                text = savedUsername.value,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp)
            )

            Image(
                painter = rememberAsyncImagePainter(uri.value),
                contentDescription = "Captured Image",
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(16.dp))
//                    .border(2.dp, Color.Gray, RoundedCornerShape(16.dp))
            )


        }


        // ردیف اول: "اسناد درسی" و "محل‌ها"
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DashboardItem(
                title = "اسناد درسی",
                icon = Icons.Default.Folder // جایگزین آیکون مناسب کنید
            )
            DashboardItem(
                title = "محل‌ها",
                icon = Icons.Default.LocationOn // جایگزین آیکون مناسب کنید
            )
        }

        // ردیف دوم: "پروژه‌های درسی" و "تحقیقاتی"
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DashboardItem(
                title = "پروژه‌های درسی",
                icon = Icons.Default.List // جایگزین آیکون مناسب کنید
            )
            DashboardItem(
                title = "تحقیقاتی",
                icon = Icons.Default.Science // جایگزین آیکون مناسب کنید
            )
        }

        // ردیف سوم: "کلاس‌های گروهی" و "آزمون‌گیری"
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DashboardItem(
                title = "کلاس‌های گروهی",
                icon = Icons.Default.Group // جایگزین آیکون مناسب کنید
            )
            DashboardItem(
                title = "آزمون‌گیری",
                icon = Icons.Default.Assignment // جایگزین آیکون مناسب کنید
            )
        }
    }
}

@Composable
fun DashboardItem(title: String, icon: ImageVector) {
    Box(
        modifier = Modifier
            .sizeIn(minHeight = 10.dp, maxHeight = 150.dp, minWidth = 10.dp, maxWidth = 150.dp)
            .aspectRatio(1f) // برای ساختن یک باکس مربعی
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .clickable { /* افزودن عملکرد کلیک */ }
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}