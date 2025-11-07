package com.example.pract1_5

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Task5() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.LightGray)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .clip(CircleShape)
                .background(Color(0xFFFF6600))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "АА",
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}