package com.example.myignaw

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Fragrance(
    val name: String,
    val description: String,
    val photo: Int,
    val fragranceDescription: String,
    val topNotes: String,
    val middleNotes: String,
    val bottomNotes: String,

) : Parcelable

