package com.example.myapplication22


import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.myapplication22.database.Student
import com.example.myapplication22.database.UpdateStudent
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import kotlinx.coroutines.tasks.await

fun onEditClick(student: Student, navController: NavController) {

    UpdateStudent.student = student
    navController.navigate(Screens.Signup.screens)

}

fun onDeleteClick(student: Student) {}


@Composable
fun StudentListScreenn(navController: NavController) {
    var students by remember { mutableStateOf<List<Student>>(emptyList()) }
    var loading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    val db = FirebaseFirestore.getInstance()

    LaunchedEffect(Unit) {
        try {
            val snapshot = db.collection("mydb").get().await()

            Log.d("Firestore", "Document count: ${snapshot.size()}") // تعداد اسناد دریافتی

            students = snapshot.documents.mapNotNull { document ->
                Log.d("Firestore", "Document data: ${document.data}") // نمایش داده‌ها

                val code = document.getString("code").orEmpty()
                val firstName = document.getString("firstName").orEmpty()
                val lastName = document.getString("lastName").orEmpty()
                val birthday = document.getString("birthday").orEmpty()
                val field = document.getString("field").orEmpty()
                val profileImg = document.getString("profileImg").orEmpty()

                if (firstName.isNotEmpty() && lastName.isNotEmpty()) {
                    Student(code, firstName, lastName, birthday, field, Uri.parse(profileImg))
                } else null
            }

            if (students.isEmpty()) {
                Log.e("Firestore", "No students found!")
                errorMessage = "هیچ دانش‌آموزی یافت نشد"
            }
        } catch (e: Exception) {
            Log.e("Firestore", "Error: ${e.message}")
            errorMessage = "خطا در بارگیری داده‌ها: ${e.message}"
        } finally {
            loading = false
        }
    }


    when {
        loading -> {
            Text("در حال بارگذاری...", Modifier.padding(16.dp))
        }

        errorMessage != null -> {
            Text(errorMessage!!, Modifier.padding(16.dp))
        }

        students.isNotEmpty() -> {
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)) {
                items(students.size) { index ->
                    StudentCardd(
                        students[index], navController
//                        onEditClick(students[index], onDeleteClick(students[index]
                    )
                }
            }
        }
    }
}


@Composable
fun StudentCardd(
    student: Student,
    navController: NavController
//    onEditClick: (Student) -> Unit,   // برای ویرایش اطلاعات
//    onDeleteClick: (Student) -> Unit // برای حذف اطلاعات
) {


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = rememberAsyncImagePainter(student.profileImg),
                    contentDescription = "Student Icon",
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape), // برای گرد کردن تصویر
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        "Name: ${student.firstName} ${student.lastName}",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text("Code: ${student.code}", style = MaterialTheme.typography.bodyMedium)
                    Text(
                        "Birth Date: ${student.birthday}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text("Field: ${student.field}", style = MaterialTheme.typography.bodyMedium)
                }
            }
            Spacer(modifier = Modifier.height(12.dp))

            // دکمه‌های حذف و ویرایش
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = { onEditClick(student, navController) }) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit", tint = Color.Blue)
                }
                IconButton(onClick = { onDeleteClick(student) }) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete", tint = Color.Red)
                }
            }
        }
    }
}

