package com.example.helloandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.helloandroid.ui.theme.HelloAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MyScreen(modifier: Modifier = Modifier) {
    val PersonalInfo = "Name: Yuanhang Xu\nEmail: xxxqivzz@bu.edu"
    val changed  = "Message changed "

    var isReturn by remember { mutableStateOf(true) }
    val message = if (isReturn) PersonalInfo else changed

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = message, fontSize = 25.sp)

        Spacer(modifier = Modifier.height(25.dp))

        Button(onClick = {
            isReturn = !isReturn
        }) {
            Text(if (isReturn) "Change" else "Back")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyScreen() {
    HelloAndroidTheme {
        MyScreen()
    }
}
