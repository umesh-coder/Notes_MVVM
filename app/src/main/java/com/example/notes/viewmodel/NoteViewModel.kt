package com.example.notes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.model.Note
import com.example.notes.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(app: Application, private val noteRepository: NoteRepository) :
    AndroidViewModel(app) {

    /**
     * Add note
     *
     * @param note
     */

    fun addNote(note: Note) = viewModelScope.launch {
        noteRepository.insertNote(note)
    }

    /**
     * Delete note
     *
     * @param note
     */
    fun deleteNote(note: Note) = viewModelScope.launch {

        noteRepository.deleteNote(note)
    }

    /**
     * Update note
     *
     * @param note
     */
    fun updateNote(note: Note) = viewModelScope.launch {

        noteRepository.updateNote(note)
    }

    /**
     * Get all notes
     *
     */
    fun getAllNotes() = noteRepository.getAllNotes()

    /**
     * Search note
     *
     * @param query
     */
    fun searchNote(query: String?) = noteRepository.searchNote(query)

}