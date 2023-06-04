package com.example.gamecorner

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val name: String,
    val description: String,
    val image: Int,
    val detail: String
): Parcelable
