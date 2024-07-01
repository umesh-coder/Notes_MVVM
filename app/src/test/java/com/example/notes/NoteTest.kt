package com.example.notes


import android.os.Parcel
import android.os.Parcelable
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.notes.model.Note
import kotlinx.parcelize.Parcelize
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NoteTest {

    @Parcelize
    data class TestNote(
        val id: Int,
        val noteTitle: String,
        val noteDescription: String
    ) : Parcelable


    @Test
    fun testDescribeContents() {
        val note = Note(
            id = 1,
            noteTitle = "Test Title",
            noteDescription = "Test Description"
        )

        assertEquals(0, note.describeContents())
    }

    @Test
    fun testCreatorNewArray() {
        val size = 5
        val notes: Array<Note?> = arrayOfNulls(size)
        assertEquals(size, notes.size)
    }
}
