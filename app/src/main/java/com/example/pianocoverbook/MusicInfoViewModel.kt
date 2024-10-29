package com.example.pianocoverbook

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MusicInfoViewModel(application: Application) : AndroidViewModel(application) {
    private val musicInfoDao: MusicInfoDao = Room.databaseBuilder(
        application,
        MusicInfoDatabase::class.java, "music_info_database"
    ).build().musicInfoDao()

    private val _musicInfo = MutableStateFlow<List<MusicInfo>>(emptyList())
    val musicInfo: StateFlow<List<MusicInfo>> = _musicInfo

    init {
        viewModelScope.launch {
            _musicInfo.value = musicInfoDao.getAllMusicInfo()
        }
    }

    fun saveValues(value: List<String>){
        viewModelScope.launch {

        }
    }

    fun insertMusicInfo(musicInfo: MusicInfo) {
        viewModelScope.launch {
            musicInfoDao.insertMusicInfo(musicInfo)
            _musicInfo.value = musicInfoDao.getAllMusicInfo()
        }
    }

    fun deleteMusicInfo(musicInfo: MusicInfo) {
        viewModelScope.launch {
            musicInfoDao.deleteMusicInfo(musicInfo)
            _musicInfo.value = musicInfoDao.getAllMusicInfo()
        }
    }
}
