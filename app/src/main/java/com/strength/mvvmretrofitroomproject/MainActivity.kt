package com.strength.mvvmretrofitroomproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.strength.mvvmretrofitroomproject.api.QuoteService
import com.strength.mvvmretrofitroomproject.api.RetrofitHelper
import com.strength.mvvmretrofitroomproject.repository.QuoteRepository
import com.strength.mvvmretrofitroomproject.viewmodels.MainViewModel
import com.strength.mvvmretrofitroomproject.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quoteRepository = (application as QuoteApplication).quoteRepository

        mainViewModel = ViewModelProvider(this@MainActivity, MainViewModelFactory(quoteRepository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this@MainActivity, Observer {
            Log.i("MainDebug", it.results.toString())
        })
    }
}