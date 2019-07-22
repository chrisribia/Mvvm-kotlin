package com.example.mvvm.data.ui.ui.auth.Quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.data.ui.data.repositories.QuotesRepository

class QuotesViewModelFactory (
    private val repository: QuotesRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(repository) as T
    }
}