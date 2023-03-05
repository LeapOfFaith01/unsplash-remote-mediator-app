package br.tospendtime.unsplashapp.model
import kotlinx.serialization.Serializable

@Serializable
data class Urls(
    val regular:String,
    val full: String,
    val small: String,
    val thumb: String,
)
