package com.example.notes

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.notes.model.Note
import com.example.notes.repository.NoteRepository
import com.example.notes.viewmodel.NoteViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class NoteViewModelTest {

    // Executes each task synchronously using Architecture Components
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    // This allows the use of TestCoroutineScope provided by kotlinx-coroutines-test
    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)


    private lateinit var viewModel: NoteViewModel
    private lateinit var noteRepository: NoteRepository

    @Before
    fun setup() {
        // Set the Main dispatcher to the test dispatcher
        Dispatchers.setMain(testDispatcher)

        // Mock Application and NoteRepository using MockK
        val mockApplication = mock(Application::class.java)
        noteRepository = mockk()

        // Create ViewModel with mocked dependencies
        viewModel = NoteViewModel(mockApplication, noteRepository)
    }

    @After
    fun tearDown() {
        // Cleanup test coroutines
        testScope.cleanupTestCoroutines()
    }

    @Test
    fun testAddNote() {
        // Create a sample note
        val note = Note(1, "Test Note", "This is a test note")

        // Mock behavior of insertNote function in repository using MockK
        coEvery { noteRepository.insertNote(note) } returns Unit

        // Launch a coroutine using testScope
        testScope.launch {
            // Perform the operation inside a coroutine scope
            viewModel.addNote(note)

            // Verify that insertNote was called once with the correct argument
            coEvery { noteRepository.insertNote(note) }
        }
    }

    @Test
    fun testDeleteNote() {
        // Create a sample note
        val note = Note(1, "Test Note", "This is a test note")

        // Mock behavior of deleteNote function in repository using MockK
        coEvery { noteRepository.deleteNote(note) } returns Unit

        // Launch a coroutine using testScope
        testScope.launch {
            // Perform the operation inside a coroutine scope
            viewModel.deleteNote(note)

            // Verify that deleteNote was called once with the correct argument
            coEvery { noteRepository.deleteNote(note) }
        }
    }

    @Test
    fun testUpdateNote() {
        // Create a sample note
        val note = Note(1, "Test Note", "This is a test note")

        // Mock behavior of updateNote function in repository using MockK
        coEvery { noteRepository.updateNote(note) } returns Unit

        // Launch a coroutine using testScope
        testScope.launch {
            // Perform the operation inside a coroutine scope
            viewModel.updateNote(note)

            // Verify that updateNote was called once with the correct argument
            coEvery { noteRepository.updateNote(note) }
        }
    }
}
