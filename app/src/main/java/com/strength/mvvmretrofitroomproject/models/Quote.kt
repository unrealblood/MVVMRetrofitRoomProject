package com.strength.mvvmretrofitroomproject.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("quotes_table")
data class Quote(
    @PrimaryKey(autoGenerate = true)
    val quoteId : Int,
    val _id: String,
    val author: String,
    val authorSlug: String,
    val content: String,
    val dateAdded: String,
    val dateModified: String,
    val length: Int,
)