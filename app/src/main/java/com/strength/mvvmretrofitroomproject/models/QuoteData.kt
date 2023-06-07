package com.strength.mvvmretrofitroomproject.models

data class QuoteData(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<Quote>,
    val totalCount: Int,
    val totalPages: Int
)