package com.lalosapps.bookshelfapp.data.repository

interface BooksRepository {
    suspend fun getBooksImages(query: String): List<String>?
}