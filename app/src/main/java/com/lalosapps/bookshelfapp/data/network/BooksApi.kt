package com.lalosapps.bookshelfapp.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BooksApi {

    @GET("volumes")
    suspend fun searchBooks(
        @Query("q") query: String = "cicero"
    ): Response<BooksDto>

    @GET("volumes/{id}")
    suspend fun getBook(
        @Path("id") query: String = "24yRRvkgsc8C"
    ): Response<Book>
}