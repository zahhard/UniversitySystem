package com.example.myapplication22.database

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey


data class Student(
    var code: Int = 0,
    val name: String = "",
    val lastName: String = "",
    val birthDate: String = "",
    val field: String = "",
    val icon: Uri
)

//fun dummyData() : List<Student>{
//    val s1 = Student(123456, "Zahra1", "Davardoust", "Calendar.getInstance(", "Computer")
//    val s2 = Student(123456, "Zahra2", "Davardoust", "Calendar.getInstance()", "Computer")
//    val s3= Student(123456, "Zahra3", "Davardoust", Calendar.getInstance(), "Computer")
//    val s4 = Student(123456, "Zahra4", "Davardoust", Calendar.getInstance(), "Computer")
//    val s5 = Student(123456, "Zahra5", "Davardoust", "Calendar.getInstance()", "Computer")
//    var a = listOf(s1, s2, s3, s4, s5)
//
//    return a
//}
