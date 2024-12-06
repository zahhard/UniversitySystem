package com.example.myapplication22

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.rememberAsyncImagePainter
import java.io.File
import java.io.FileOutputStream

@Composable
fun CameraCaptureScreen() : Uri? {
    val context = LocalContext.current
    val capturedImageUri = remember { mutableStateOf<Uri?>(null) }

    // ActivityResultLauncher برای گرفتن عکس از دوربین
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) { bitmap ->
        if (bitmap != null) {
            // عکس گرفته شده را ذخیره کنید
//            val uri = saveBitmapToCache(context, bitmap)
            val uri = saveImageToGallery(context, bitmap)
            capturedImageUri.value = uri
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // دکمه باز کردن دوربین
        Button(
            onClick = {
                launcher.launch(null) // گرفتن عکس بدون مشخص کردن محل ذخیره موقت
            },
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Text("باز کردن دوربین")
        }

        Spacer(modifier = Modifier.height(16.dp))


        // نمایش عکس گرفته شده (در صورت موجود بودن)
        capturedImageUri.value?.let { uri ->
            Image(
                painter = rememberAsyncImagePainter(uri),
                contentDescription = "Captured Image",
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .border(2.dp, Color.Gray, RoundedCornerShape(16.dp))
            )
        } ?: Text("هیچ عکسی گرفته نشده است", color = Color.Gray)
    }
    return capturedImageUri.value
}

// تابع ذخیره عکس در کش
fun saveBitmapToCache(context: Context, bitmap: Bitmap): Uri {
    val file = File(context.cacheDir, "captured_image_${System.currentTimeMillis()}.jpg")
    FileOutputStream(file).use { out ->
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)
    }
    return file.toUri()
}


fun saveImageToGallery(context: Context, bitmap: Bitmap): Uri? {
    val contentResolver = context.contentResolver
    val contentValues = ContentValues().apply {
        put(MediaStore.Images.Media.DISPLAY_NAME, "image_${System.currentTimeMillis()}.jpg")
        put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
        put(MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES) // مسیر ذخیره عکس
    }

    val imageUri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)

    imageUri?.let { uri ->
        contentResolver.openOutputStream(uri)?.use { outputStream ->
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream) // ذخیره عکس با فرمت JPEG
        }
    }

    return imageUri
}