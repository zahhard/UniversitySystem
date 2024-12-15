package com.example.myapplication22

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)  // مقداردهی Firebase
//        enableEdgeToEdge()



//        Handler(Looper.getMainLooper()).postDelayed({
//            showNotification(this, "سلام!", "این یک نوتیفیکیشن تستی است.")
//        }, 10000) // 10000 میلی ثانیه = 10 ثانیه

        setContent {
            Surface(
                color = MaterialTheme.colorScheme.background
            ) {
                NavDrawer()
//                StudentScreen()
//                StudentListScreenn()

//                SignUpScreen()

            }
        }
    }

}
