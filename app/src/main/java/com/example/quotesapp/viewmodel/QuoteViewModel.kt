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


//class QuoteViewModel(
//    private val repository: QuoteRepository = DefaultQuoteRepository()
//): ViewModel() {
//    private val _quotes = MutableStateFlow<List<Quote>>(repository.getQuotes())
//    val quotes: StateFlow<List<Quote>> = _quotes.asStateFlow()
//    private  val _isLoading = MutableStateFlow(false)
//    val isLoading : StateFlow<Boolean> = _isLoading.asStateFlow()
//    fun loadQuote(){
//        if (_isLoading.value) return
//        viewModelScope.launch(Dispatchers.IO) {
//            _isLoading.value = true
//            delay(5000L)
//            _quotes.value = repository.getQuotes()
//            _isLoading.value = false
//        }
//    }
//
//    init {
//        // If you later load from DB/network, you already have the pattern.
//    }
//
//    fun shuffle() = _quotes.update { it.shuffled() }
//
//    fun addQuote(q: Quote) = _quotes.update { it + q }
//
//    fun removeQuote(index: Int) = _quotes.update { list ->
//        if (index in list.indices) list.toMutableList().apply { removeAt(index) } else list
//    }
//}


class QuoteViewModel(
    private val repository: QuoteRepository = DefaultQuoteRepository(),
    //private val randomRepository: MyQuoteRepository
): ViewModel() {
    private val _quotes = MutableStateFlow<List<Quote>>(emptyList())
    val quotes: StateFlow<List<Quote>> = _quotes.asStateFlow()
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

//    private val _randomQuote = MutableStateFlow<Quote?>(null)
//    val randomQuote: StateFlow<Quote?> = _randomQuote.asStateFlow()
//    fun loadRandomQuote(){
//        viewModelScope.launch {
//            randomRepository.fetchData().collect {result->
//                when(result){
//                    is Result.Error -> {
//                        _isLoading.value = false
//                    }
//                    Result.Loading -> {
//                        _isLoading.value = true
//                    }
//                    is Result.Success<Any> -> {
//                        _randomQuote.value = result.data as? Quote
//                        _isLoading.value = false
//                    }
//                }
//            }
//        }
//    }
    fun loadQuote() {
        if (_isLoading.value) return
        viewModelScope.launch {
            _isLoading.value = true
            delay(2000L)
            _quotes.value = repository.getQuotes()
            _isLoading.value = false
        }
    }
    fun shuffle() = _quotes.update { it.shuffled() }

}