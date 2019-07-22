package com.example.mvvm.data.ui.data.network.responses

import com.example.mvvm.data.ui.data.db.entites.Quote

data class QuotesResponse (
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)