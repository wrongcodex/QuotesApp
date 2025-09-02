package com.example.quotesapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotesapp.model.DefaultQuoteRepository
import com.example.quotesapp.model.Quote
import com.example.quotesapp.model.QuoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class QuoteViewModel(
    private val repository: QuoteRepository = DefaultQuoteRepository()
): ViewModel() {
    private val _quotes = MutableStateFlow<List<Quote>>(emptyList())
    val quotes: StateFlow<List<Quote>> = _quotes.asStateFlow()

    init {
        // If you later load from DB/network, you already have the pattern.
        viewModelScope.launch {
            _quotes.value = repository.getQuotes()
        }
    }

    fun shuffle() = _quotes.update { it.shuffled() }

    fun addQuote(q: Quote) = _quotes.update { it + q }

    fun removeQuote(index: Int) = _quotes.update { list ->
        if (index in list.indices) list.toMutableList().apply { removeAt(index) } else list
    }
}