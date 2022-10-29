package com.lalosapps.bookshelfapp.data.repository

import com.lalosapps.bookshelfapp.data.network.BooksApi

class DefaultBooksRepository(
    private val booksApi: BooksApi
) : BooksRepository {

    override suspend fun getBooksImages(query: String): List<String>? {
        return try {
            val response = booksApi.searchBooks(query)
            if (response.isSuccessful) {
                val data = response.body()!!
                data.books?.let { books ->
                    books.map { book -> book.volumeInfo.imageLinks.httpsThumbnail }
                }
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }
}