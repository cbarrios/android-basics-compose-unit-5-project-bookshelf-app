package com.lalosapps.bookshelfapp.di

import com.lalosapps.bookshelfapp.data.network.BooksApi
import com.lalosapps.bookshelfapp.data.repository.BooksRepository

interface AppContainer {
    val booksApi: BooksApi
    val booksRepository: BooksRepository
}

