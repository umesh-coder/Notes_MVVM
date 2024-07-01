package com.example.notes

import com.example.notes.database.NoteDao
import com.example.notes.database.NoteDatabase
import com.example.notes.model.Note
import com.example.notes.repository.NoteRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class NoteRepositoryTest {

    private lateinit var noteDao: NoteDao
    private lateinit var noteDatabase: NoteDatabase
    private lateinit var noteRepository: NoteRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        noteDao = mock(NoteDao::class.java)
        noteDatabase = mock(NoteDatabase::class.java)
        `when`(noteDatabase.getNoteDao()).thenReturn(noteDao)
        noteRepository = NoteRepository(noteDatabase)
    }

    @Test
    fun testInsertNote() = runBlocking {
        val note = Note(
            id = 1,
            noteTitle = "Test Title",
            noteDescription = "Test Description"
        )
        noteRepository.insertNote(note)
        verify(noteDao, times(1)).insertNote(note)
    }

    @Test
    fun testDeleteNote() = runBlocking {
        val note = Note(
            id = 1,
            noteTitle = "Test Title",
            noteDescription = "Test Description"
        )
        noteRepository.deleteNote(note)
        verify(noteDao, times(1)).deleteNote(note)
    }

    @Test
    fun testUpdateNote() = runBlocking {
        val note = Note(
            id = 1,
            noteTitle = "Test Title",
            noteDescription = "Test Description"
        )
        noteRepository.updateNote(note)
        verify(noteDao, times(1)).updateNote(note)
    }

    @Test
    fun testGetAllNotes() {
        noteRepository.getAllNotes()
        verify(noteDao, times(1)).getAllNotes()
    }

    @Test
    fun testSearchNote() {
        val query = "Test"
        noteRepository.searchNote(query)
        verify(noteDao, times(1)).searchNote(query)
    }
}
