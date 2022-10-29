package com.lalosapps.bookshelfapp.di

import com.lalosapps.bookshelfapp.data.network.BooksApi

interface AppContainer {
    val booksApi: BooksApi
}

