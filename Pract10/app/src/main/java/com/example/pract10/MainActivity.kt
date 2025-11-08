package com.example.pract10

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlin.random.Random

data class Cart(
    val products: List<Product>
)

data class Product(
    val id: Int,
    val name: String,
    val price: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(modifier = Modifier.fillMaxSize().wrapContentWidth().wrapContentHeight()) {
                ShoppingCartScreen()
            }
        }
    }
}

@Composable
fun ShoppingCartScreen() {
    val context = LocalContext.current

    var products by remember {
        mutableStateOf(
            listOf(
                Product(0, "Товар #1", 100),
                Product(1, "Товар #2", 150),
                Product(2, "Товар #3", 56)
            )
        )
    }

    val totalSum by remember(products) {
        derivedStateOf { products.sumOf { it.price } }
    }

    Column {
        for (product in products) {
            Text(text = "${product.name} - ${product.price} рублей")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Товаров на сумму: $totalSum рублей")

        LaunchedEffect(totalSum) {
            if (totalSum > 500) {
                Toast.makeText(context, "Доставка бесплатная!", Toast.LENGTH_SHORT).show()
            }
        }

        AddProductSection {
            products = products + Product(
                id = products.size,
                name = "Товар #${products.size + 1}",
                price = Random.nextInt(100, 201)
            )
        }

        RemoveProductSection(products) {
            products = products.dropLast(1)
        }
    }
}

@Composable
fun AddProductSection(
    onAdd: () -> Unit
) {
    Button(onClick = onAdd) {
        Text(text = "Добавить товар")
    }
}

@Composable
fun RemoveProductSection(
    products: List<Product>,
    onRemove: () -> Unit
) {
    if (products.isNotEmpty()) {
        Button(onClick = onRemove) {
            Text(text = "Удалить товар")
        }
    }
}