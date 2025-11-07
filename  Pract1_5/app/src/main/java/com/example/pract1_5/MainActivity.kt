package com.example.pract1_5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Box(
                        modifier = Modifier.padding(vertical = 32.dp)
                    ) {
                        CustomButton()
                    }
                    Box(
                        modifier = Modifier.padding(vertical = 128.dp)
                    ) {
                        Task5()
                    }
                    Hello(name = null)
                }
            }
        }
    }
}

@Composable
fun Hello(name: String?) {
    val displayName = name ?: "Имя не задано"
    Text(
        text = displayName,
        modifier = Modifier.wrapContentHeight().wrapContentWidth())
}

@Preview(
    name = "Portrait",
    showSystemUi = true,
    device = "id:pixel_5",
    heightDp = 500,
    widthDp = 385
)
@Composable
fun HelloPreviewPortrait() {
    Hello("Портрет")
}

@Preview(
    name = "Landscape",
    showSystemUi = true,
    device = "id:pixel_tablet",
    heightDp = 700,
    widthDp = 1300
)
@Composable
fun HelloPreviewLandscape() {
    Hello("Альбомная")
}

@Preview(
    name = "Round",
    device = "id:wearos_large_round",
    widthDp = 200,
    heightDp = 200,
    backgroundColor = 0xFFFFFF00,
    showBackground = true
)
@Composable
fun HelloPreviewRound() {
    Hello("Круг")
}