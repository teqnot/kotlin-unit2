package com.example.pract1_5

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DescriptionText(
    content: String,
    modifier: Modifier = Modifier,
    style: TextStyle = TextStyle.Default
) {
    Text(
        text = content,
        modifier = modifier,
        style = style
    )
}

@Preview(name = "Option 1", showBackground = true)
@Composable
fun Option1() {
    val text = androidx.compose.ui.res.stringResource(id = R.string.compose_description)
    DescriptionText(
        content = text,
        style = TextStyle(
            color = Color.Green,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center
        )
    )
}

@Preview(name = "Option 2", showBackground = true)
@Composable
fun Option2() {
    val text = androidx.compose.ui.res.stringResource(id = R.string.compose_description)
    Text(
        text = text,
        modifier = Modifier.padding(16.dp),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Preview(name = "Option 3", showBackground = true)
@Composable
fun Option3() {
    val text = androidx.compose.ui.res.stringResource(id = R.string.compose_description)

    val annotatedText = buildAnnotatedString {
        pushStyle(
            SpanStyle(
                color = Color.Black,
                fontSize = 24.sp,
                background = Color.Transparent,
                textDecoration = TextDecoration.Underline
            )
        )
        append(text)
        pop()
    }

    Text(
        text = annotatedText,
        modifier = Modifier
            .padding(top = 48.dp)
            .background(Color.Green)
            .padding(16.dp)
    )
}