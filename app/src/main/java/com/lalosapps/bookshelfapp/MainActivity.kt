package com.lalosapps.bookshelfapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.lalosapps.bookshelfapp.ui.theme.BookshelfAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookshelfAppTheme {
                var string by remember { mutableStateOf("") }
                LaunchedEffect(key1 = Unit) {
                    val myApp = application as BookshelfApplication
                    val list = myApp.container.booksRepository.getBooksImages("cicero")
                    list?.let { string = it.firstOrNull() ?: "" }
                }
                if (string.isNotEmpty()) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        PhotoCard(photo = string)
                    }
                }
            }
        }
    }
}

@Composable
fun PhotoCard(photo: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
            .aspectRatio(1f),
        elevation = 8.dp,
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(photo)
                .crossfade(true)
                .build(),
            contentDescription = "Photo",
            contentScale = ContentScale.FillBounds
        )
    }
}