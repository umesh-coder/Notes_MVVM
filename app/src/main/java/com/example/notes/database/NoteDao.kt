package com.example.notes.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.notes.model.Note


@Dao
interface NoteDao {

    /**
     * Insert note
     *
     * @param note
     */
    //Replace the dupplict key data with new one
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    /**
     * Update note
     *
     * @param note
     */
    @Update
    suspend fun updateNote(note: Note)

    /**
     * Delete note
     *
     * @param note
     */
    @Delete
    suspend fun deleteNote(note: Note)

    /**
     * Get all notes
     *
     * @return
     */
    @Query("SELECT * FROM NOTES ORDER BY id DESC")
    fun getAllNotes(): LiveData<List<Note>>

    /**
     * Search note
     *
     * @param query
     * @return
     */
    @Query("SELECT * FROM NOTES WHERE noteTitle LIKE :query OR noteDescription LIKE :query")
    fun searchNote(query: String?): LiveData<List<Note>>


}