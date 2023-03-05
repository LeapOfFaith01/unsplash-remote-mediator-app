package br.tospendtime.unsplashapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.tospendtime.unsplashapp.util.Constants

@Entity(tableName = Constants.UNSPLASH_REMOTE_KEYS_TABLE)
data class UnsplashRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val prevPage: Int?,
    val nextPage: Int?
)
