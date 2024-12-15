package com.example.myapplication22

import androidx.compose.animation.core.AnimationConstants
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.myapplication22.ui.theme.mistyBlue
import com.example.myapplication22.ui.theme.tealGreen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {


    // وضعیت انیمیشن
    var startAnimation by remember { mutableStateOf(false) }

    // مقدار شفافیت
    val alpha by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 2000)
    )

    // مقدار حرکت عمودی
    val offsetY by animateFloatAsState(
        targetValue = if (startAnimation) 0f else -200f,
        animationSpec = tween(durationMillis = 2000)
    )

    // اجرای انیمیشن
    LaunchedEffect(Unit) {
        delay(500) // تاخیر برای شروع انیمیشن
        startAnimation = true
    }




    // زمانبندی برای جابجایی به صفحه اصلی
    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(3000)  // 3 ثانیه تأخیر
        navController.navigate("StudentList") {
            popUpTo("Splash") { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(mistyBlue),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // بارگذاری تصویر از منابع داخلی
            Image(
                painter = painterResource(id = R.drawable.qqq), // تغییر نام تصویر
                contentDescription = "Logo Animation",
                modifier = Modifier
                    .graphicsLayer(
                        translationY = offsetY // حرکت عمودی
                    )
                    .alpha(alpha), // تغییر شفافیت
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "اپلیکیشن دانشگاه",
                fontSize = 32.sp,
                color = tealGreen
            )
        }
    }
}
