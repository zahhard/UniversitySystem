package com.example.myapplication22.database

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore


fun saveStudentData(student: Student) {
    val studentRef = db.collection("mydb").document(student.code.toString())

    studentRef.set(student)
        .addOnSuccessListener {
            Log.d("Firestore", "Student data saved successfully!")
        }
        .addOnFailureListener { e ->
            Log.e("Firestore", "Error saving student data", e)
        }
}
