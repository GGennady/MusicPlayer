package com.example.musicplayer.db

import com.example.musicplayer.Constants.SONG_COLLECTION
import com.example.musicplayer.models.Song
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObjects
import kotlinx.coroutines.tasks.await

class MusicDatabase {

    // getting instance of FirebaseFirestore database singleton
    private val firestore = FirebaseFirestore.getInstance()

    // getting reference to the song collection
    private val songCollection = firestore.collection(SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song> {
        return try {
            songCollection.get().await().toObjects(Song::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }
}