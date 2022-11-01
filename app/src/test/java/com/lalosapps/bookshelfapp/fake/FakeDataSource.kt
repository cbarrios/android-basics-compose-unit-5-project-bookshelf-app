package com.lalosapps.bookshelfapp.fake

import com.lalosapps.bookshelfapp.data.network.Book
import com.lalosapps.bookshelfapp.data.network.BooksDto
import com.lalosapps.bookshelfapp.data.network.Thumbnails
import com.lalosapps.bookshelfapp.data.network.VolumeInfo

object FakeDataSource {

    val books = listOf(
        Book(
            "1",
            VolumeInfo(Thumbnails("url1"))
        ),
        Book(
            "2",
            VolumeInfo(Thumbnails("url2"))
        )
    )

    val dto = BooksDto(books)

    val dtoNoBooks = BooksDto(null)

    val images = books.mapNotNull { it.volumeInfo.imageLinks?.httpsThumbnail }
}