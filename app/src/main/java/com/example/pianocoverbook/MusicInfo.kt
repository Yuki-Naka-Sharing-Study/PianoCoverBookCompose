package com.example.pianocoverbook

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "music_info")
data class MusicInfo(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val nameOfMusic: String,
    val nameOfArtist: String,
    val nameOfMemo: String,
    val levelOfRightHand: Int,
    val levelOfLeftHand: Int,
)