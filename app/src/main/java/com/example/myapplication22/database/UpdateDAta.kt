package com.example.myapplication22.database

import com.google.firebase.firestore.FirebaseFirestore
import android.util.Log

val db = FirebaseFirestore.getInstance()

fun updateStudentData(code: Int, updates: Map<String, Any>) {
    val studentRef = db.collection("students").document(code.toString())

    studentRef.update(updates)
        .addOnSuccessListener {
            Log.d("Firestore", "Student data updated successfully!")
        }
        .addOnFailureListener { e ->
            Log.e("Firestore", "Error updating student data", e)
        }
}
