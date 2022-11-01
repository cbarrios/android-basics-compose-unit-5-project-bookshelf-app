package com.lalosapps.bookshelfapp.fake

import com.lalosapps.bookshelfapp.rules.TestDispatcherRule
import com.lalosapps.bookshelfapp.ui.BooksUiState
import com.lalosapps.bookshelfapp.ui.BooksViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Rule
import org.junit.Test


@ExperimentalCoroutinesApi
class BooksViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun booksViewModel_getBooksImages_verifyBooksUiStateSuccess() = runTest {
        val booksViewModel = BooksViewModel(booksRepository = FakeBooksRepository())
        assertEquals(
            BooksUiState.Success(FakeDataSource.images),
            booksViewModel.booksUiState.value
        )
    }

    @Test
    fun booksViewModel_getBooksImagesWithEmptyResult_verifyBooksUiStateSuccess() = runTest {
        val fakeRepository = FakeBooksRepository().apply { returnEmpty = true }
        val booksViewModel = BooksViewModel(booksRepository = fakeRepository)
        assertEquals(
            BooksUiState.Success(emptyList()),
            booksViewModel.booksUiState.value
        )
    }

    @Test
    fun booksViewModel_getBooksImagesWithNullResult_verifyBooksUiStateError() = runTest {
        val fakeRepository = FakeBooksRepository().apply { returnNull = true }
        val booksViewModel = BooksViewModel(booksRepository = fakeRepository)
        assertEquals(
            BooksUiState.Error,
            booksViewModel.booksUiState.value
        )
    }

    @Test
    fun booksViewModel_getBooksImagesWithEmptyQuery_verifyBooksUiStateUnchanged() = runTest {
        val booksViewModel = BooksViewModel(booksRepository = FakeBooksRepository())
        val state = booksViewModel.booksUiState.value
        booksViewModel.getBooksImages("")
        assertEquals(
            state,
            booksViewModel.booksUiState.value
        )
    }

    @Test
    fun booksViewModel_getBooksImagesWithQueryAndPreviousError_verifyBooksUiStateChanged() =
        runTest {
            val fakeRepository = FakeBooksRepository().apply { returnNull = true }
            val booksViewModel = BooksViewModel(booksRepository = fakeRepository)
            val state = booksViewModel.booksUiState.value
            fakeRepository.returnNull = false
            booksViewModel.getBooksImages("miami")
            assertNotEquals(
                state,
                booksViewModel.booksUiState.value
            )
        }

    @Test
    fun booksViewModel_getBooksImagesWithQueryAndPreviousEmptyResult_verifyBooksUiStateChanged() =
        runTest {
            val fakeRepository = FakeBooksRepository().apply { returnEmpty = true }
            val booksViewModel = BooksViewModel(booksRepository = fakeRepository)
            val state = booksViewModel.booksUiState.value
            fakeRepository.returnEmpty = false
            booksViewModel.getBooksImages("miami")
            assertNotEquals(
                state,
                booksViewModel.booksUiState.value
            )
        }
}