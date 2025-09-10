package com.example.quotesapp.model

import com.example.quotesapp.Result
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface QuoteRepository {
    fun getQuotes(): List<Quote>
}
class DefaultQuoteRepository : QuoteRepository{
    override fun getQuotes(): List<Quote> = QuotesDataSource.quotesList
}
