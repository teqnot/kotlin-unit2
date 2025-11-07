package com.example.pract6_9

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CircleInTopRight() {
    Box(
        modifier = Modifier
            .size(240.dp, 120.dp)
            .background(Color.Black),
        contentAlignment = Alignment.TopEnd
    ) {
        Icon(
            painter = painterResource(id = R.drawable.circle),
            contentDescription = "Circle",
            tint = Color.Unspecified
        )
    }
}

@Composable
fun CircleCenteredAndTinted() {
    Box(
        modifier = Modifier
            .size(240.dp, 120.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.circle),
            contentDescription = "Circle",
            modifier = Modifier.fillMaxSize(),
            tint = Color(0xFF9C27B0)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Task6Preview() {
    Column {
        CircleInTopRight()
        Spacer(modifier = Modifier.height(16.dp))
        CircleCenteredAndTinted()
    }
}