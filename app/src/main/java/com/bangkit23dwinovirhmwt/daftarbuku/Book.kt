package com.bangkit23dwinovirhmwt.daftarbuku

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book(
    val name: String,
    val description: String,
    val book: Int,
    val publisher: String,
    val release: String
) : Parcelable
