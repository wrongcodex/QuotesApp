package com.example.quotesapp

sealed class Result<out T> {
    object Loading: Result<Nothing>()
    data class Success<Any>(val data:Any): Result<Any>()
    data class Error(val error : String, val exception: Throwable): Result<Unit>()
}