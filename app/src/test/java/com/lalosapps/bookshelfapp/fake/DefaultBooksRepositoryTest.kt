package com.lalosapps.bookshelfapp.fake

import com.lalosapps.bookshelfapp.data.repository.DefaultBooksRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class DefaultBooksRepositoryTest {

    @Test
    fun defaultBooksRepository_getBooksImages_verifyImagesList() = runTest {
        val fakeApi = FakeBooksApi().apply { hasBooks = true }
        val repository = DefaultBooksRepository(booksApi = fakeApi)
        assertEquals(FakeDataSource.images, repository.getBooksImages(""))
    }

    @Test
    fun defaultBooksRepository_getBooksImagesWithNoBooks_verifyImagesListIsEmpty() = runTest {
        val fakeApi = FakeBooksApi().apply { hasBooks = false }
        val repository = DefaultBooksRepository(booksApi = fakeApi)
        assertEquals(emptyList<String>(), repository.getBooksImages(""))
    }

    @Test
    fun defaultBooksRepository_getBooksImagesWithException_verifyImagesListIsNull() = runTest {
        val fakeApi = FakeBooksApi().apply { throwsException = true }
        val repository = DefaultBooksRepository(booksApi = fakeApi)
        assertEquals(null, repository.getBooksImages(""))
    }

    @Test
    fun defaultBooksRepository_getBooksImagesWithError_verifyImagesListIsNull() = runTest {
        val fakeApi = FakeBooksApi().apply { errorResponse = true }
        val repository = DefaultBooksRepository(booksApi = fakeApi)
        assertEquals(null, repository.getBooksImages(""))
    }
}