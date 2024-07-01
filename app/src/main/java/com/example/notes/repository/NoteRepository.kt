package com.example.notes.repository

import com.example.notes.database.NoteDatabase
import com.example.notes.model.Note

class NoteRepository(private val db: NoteDatabase) {

    /**
     * Insert note
     *
     * @param note
     */
    suspend fun insertNote(note: Note) = db.getNoteDao().insertNote(note)

    /**
     * Delete note
     *
     * @param note
     */

    suspend fun deleteNote(note: Note) = db.getNoteDao().deleteNote(note)

    /**
     * Update note
     *
     * @param note
     */
    suspend fun updateNote(note: Note) = db.getNoteDao().updateNote(note)

    /**
     * Get all notes
     *
     */
    fun getAllNotes() = db.getNoteDao().getAllNotes()

    /**
     * Search note
     *
     * @param query
     */
    fun searchNote(query: String?) = db.getNoteDao().searchNote(query)

}