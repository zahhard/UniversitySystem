package com.example.myapplication22.database

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey


//data class Student(
//    var code: Int = 0,
//    val name: String = "",
//    val lastName: String = "",
//    val birthDate: String = "",
//    val field: String = "",
//    val icon: Uri
//)

data class Student(
    var code: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val birthday: String = "",
    val field: String = "",
    val profileImg: Uri = Uri.EMPTY
)
