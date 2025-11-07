package com.example.pract6_9

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun ContactColumnPreview() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(text = "Имя: Евгений", fontWeight = FontWeight.Medium)
        Text(text = "Отчество: Андреевич", fontWeight = FontWeight.Medium)
        Text(text = "Фамилия: Лукашин", fontWeight = FontWeight.Medium)
        Text(text = "Мобильный телефон: +7 495 495 95 95", fontWeight = FontWeight.Medium)
        Text(text = "Адрес: г. Москва, 3-я улица Строителей, д. 25, кв. 12", fontWeight = FontWeight.Medium)
    }
}

@Preview(showBackground = true)
@Composable
fun ListPreview() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactCard(
            name = "Евгений",
            patrynomic = "Андреевич",
            lastname = "Лукашин",
            phone = "+7 495 495 95 95",
            address = "г. Москва, 3-я улица Строителей, д. 25, кв. 12"
        )

        ContactCard(
            name = "Василий",
            patrynomic = "Егорович",
            lastname = "Кузякин",
            phone = "---",
            address = "Ивановская область, дер. Крутово, д. 4"
        )

        ContactCard(
            name = "Людмила",
            patrynomic = "Прокофьевна",
            lastname = "Калугина",
            phone = "+7 495 788 78 78",
            address = "Москва, Большая Никитская, д. 43, кв. 290"
        )
    }
}

@Composable
private fun ContactCard(
    name: String,
    patrynomic: String,
    lastname: String,
    phone: String,
    address: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(12.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Имя: $name", fontWeight = FontWeight.Medium)
            Text(text = "Отчество: $patrynomic", fontWeight = FontWeight.Medium)
            Text(text = "Фамилия: $lastname", fontWeight = FontWeight.Medium)
            Text(text = "Мобильный телефон: $phone", fontWeight = FontWeight.Medium)
            Text(text = "Адрес: $address", fontWeight = FontWeight.Medium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactRowPreview() {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Имя: Евгений", fontWeight = FontWeight.Medium)
                Text(text = "Отчество: Андреевич", fontWeight = FontWeight.Medium)
                Text(text = "Фамилия: Лукашин", fontWeight = FontWeight.Medium)
                Text(text = "Мобильный телефон: +7 495 495 95 95", fontWeight = FontWeight.Medium)
                Text(text = "Адрес: г. Москва, 3-я улица Строителей, д. 25, кв. 12", fontWeight = FontWeight.Medium)
            }

            Icon(
                painter = painterResource(id = R.drawable.star),
                contentDescription = "Favorite",
                tint = Color.Unspecified
            )
        }
    }
}

