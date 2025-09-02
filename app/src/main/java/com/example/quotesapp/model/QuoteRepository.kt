package com.example.quotesapp.model

interface QuoteRepository {
    fun getQuotes(): List<Quote>
}

class DefaultQuoteRepository : QuoteRepository{
    override fun getQuotes(): List<Quote> = QuotesDataSource.quotesList
}