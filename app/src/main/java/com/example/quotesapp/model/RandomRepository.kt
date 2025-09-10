package com.example.quotesapp.model

import com.example.quotesapp.Result
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface RandomRepository{
    suspend fun fetchRandomQuote(): Flow<Result<Quote>>
}
class MyQuoteRepository: RandomRepository {
    override suspend fun fetchRandomQuote(): Flow<Result<Quote>> = flow {
        emit(Result.Loading)
        delay(3000L)
        try {
            val randomQuote = QuotesDataSource.quotesList.random()
            emit(Result.Success(randomQuote))
        }
        catch (e: Exception){
            emit(Result.Error("Failed To Fetch Quote!", e))
        }
    }
}