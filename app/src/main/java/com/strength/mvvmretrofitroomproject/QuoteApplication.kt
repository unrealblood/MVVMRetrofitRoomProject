package com.strength.mvvmretrofitroomproject

import android.app.Application
import com.strength.mvvmretrofitroomproject.api.QuoteService
import com.strength.mvvmretrofitroomproject.api.RetrofitHelper
import com.strength.mvvmretrofitroomproject.database.QuoteDatabase
import com.strength.mvvmretrofitroomproject.repository.QuoteRepository

class QuoteApplication : Application() {

    lateinit var quoteRepository : QuoteRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)

        val quoteDatabase = QuoteDatabase.getDatabase(applicationContext)

        quoteRepository = QuoteRepository(quoteService, quoteDatabase)
    }
}