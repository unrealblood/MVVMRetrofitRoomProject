package com.strength.mvvmretrofitroomproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.strength.mvvmretrofitroomproject.models.Quote

@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun quoteDao() : QuoteDAO

    companion object {
        @Volatile
        private var INSTANCE : QuoteDatabase? = null

        fun getDatabase(context: Context) : QuoteDatabase {
            if(INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(context,
                        QuoteDatabase::class.java,
                        "quote_database")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }

}