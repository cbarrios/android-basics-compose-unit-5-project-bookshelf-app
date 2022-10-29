package com.lalosapps.bookshelfapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import com.lalosapps.bookshelfapp.ui.theme.BookshelfAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookshelfAppTheme {
                LaunchedEffect(key1 = Unit) {
                    val myApp = application as BookshelfApplication
                    val list = myApp.container.booksApi.searchBooks()
                    println(list.body()?.books?.size)
                }
            }
        }
    }
}