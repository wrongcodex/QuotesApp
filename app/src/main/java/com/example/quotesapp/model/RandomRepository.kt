package com.example.quotesapp.model

import com.example.quotesapp.Result
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface RandomRepository{
    suspend fun fetchData(): Flow<Result<Any>>
}
class MyQuoteRepository: RandomRepository {
    suspend override fun fetchData(): Flow<Result<Any>> = flow {
        emit(Result.Loading)
        delay(3000L)
        emit(Result.Success(QuotesDataSource.quotesList.random()))
    }
}