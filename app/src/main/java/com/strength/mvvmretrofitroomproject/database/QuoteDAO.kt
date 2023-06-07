package com.strength.mvvmretrofitroomproject.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.strength.mvvmretrofitroomproject.models.Quote

@Dao
interface QuoteDAO {
    @Insert
    suspend fun addQuotes(quotes : List<Quote>)

    @Query("SELECT * FROM quotes_table")
    suspend fun getQuotes() : List<Quote>
}