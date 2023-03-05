package br.tospendtime.unsplashapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import br.tospendtime.unsplashapp.data.local.dao.UnsplashImageDao
import br.tospendtime.unsplashapp.data.local.dao.UnsplashRemoteKeysDao
import br.tospendtime.unsplashapp.model.UnsplashImage
import br.tospendtime.unsplashapp.model.UnsplashRemoteKeys

@Database(entities = [UnsplashImage::class, UnsplashRemoteKeys::class], version = 1)
abstract class UnsplashDatabase : RoomDatabase() {

    abstract fun unsplashImageDao(): UnsplashImageDao
    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeysDao

}