package com.example.mvvm.data.ui.ui.auth.Quotes

import androidx.lifecycle.ViewModel
import com.example.mvvm.data.ui.data.repositories.QuotesRepository
import com.example.mvvm.data.ui.ui.p.lazyDeferred


class QuotesViewModel(
    repository: QuotesRepository
) : ViewModel() {

    val quotes by lazyDeferred {
        repository.getQuotes()
    }
}
