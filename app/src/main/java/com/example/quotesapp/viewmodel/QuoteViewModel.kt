package com.example.quotesapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotesapp.Result
import com.example.quotesapp.model.DefaultQuoteRepository
import com.example.quotesapp.model.MyQuoteRepository
import com.example.quotesapp.model.Quote
import com.example.quotesapp.model.QuoteRepository
import com.example.quotesapp.model.RandomRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
class QuoteViewModel(
    private val repository: QuoteRepository = DefaultQuoteRepository(),
    private val randomRepository: RandomRepository = MyQuoteRepository()
): ViewModel() {
    private val _quotes = MutableStateFlow<List<Quote>>(emptyList())
    val quotes: StateFlow<List<Quote>> = _quotes.asStateFlow()
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    private val _randomQuote = MutableStateFlow<Quote?>(null)
    val randomQuote: StateFlow<Quote?> = _randomQuote.asStateFlow()
    private val _isRandomQuoteLoading = MutableStateFlow(false)
    val isRandomQuoteLoading: StateFlow<Boolean> = _isRandomQuoteLoading

    fun loadRandomQuote(){
        viewModelScope.launch {
            randomRepository.fetchRandomQuote().collect {result ->
                when(result){
                    is Result.Loading -> {
                        _isRandomQuoteLoading.update { true }
                    }
                    is Result.Error -> {
                        _isRandomQuoteLoading.update { false }
                    }
                    is Result.Success -> {
                        _randomQuote.update { result.data }
                        _isRandomQuoteLoading.update { false }
                    }
                }
            }
        }
    }

    fun loadQuote() {
        if (_isLoading.value) return
        viewModelScope.launch {
            _isLoading.update { true }
            delay(2000L)
            _quotes.update { repository.getQuotes() }
            _isLoading.update { false }
        }
    }
    fun shuffle() = _quotes.update { it.shuffled() }

    fun clearRandomQuote(){
        _randomQuote.update { null }
    }
}