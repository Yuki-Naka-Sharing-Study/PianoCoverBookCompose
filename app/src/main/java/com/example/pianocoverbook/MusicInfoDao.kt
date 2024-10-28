package com.example.pianocoverbook

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MusicInfoDao {
    @Insert
    suspend fun insert(item: MusicInfo)

    @Delete
    suspend fun delete(item: MusicInfo)

    @Query("SELECT * FROM music_info")
    suspend fun getAllItems(): List<MusicInfo>
}