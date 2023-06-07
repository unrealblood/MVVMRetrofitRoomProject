package com.strength.mvvmretrofitroomproject.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.strength.mvvmretrofitroomproject.api.QuoteService
import com.strength.mvvmretrofitroomproject.database.QuoteDatabase
import com.strength.mvvmretrofitroomproject.models.QuoteData

class QuoteRepository(private val quoteService: QuoteService, private val quoteDatabase: QuoteDatabase) {
    val quotesLiveData = MutableLiveData<QuoteData>()

    suspend fun getQuotes(page : Int) {

        //when online
        val result = quoteService.getQuotes(page)
        if(result.body() != null) {
            quoteDatabase.quoteDao().addQuotes(result.body()!!.results)
            quotesLiveData.postValue(result.body())
        }

        //when offline
        /*
        val quotes = quoteDatabase.quoteDao().getQuotes()
        val quoteList = QuoteData(1, 1, 1, quotes, 1, 1)

        quotesLiveData.postValue(quoteList)*/
    }
}