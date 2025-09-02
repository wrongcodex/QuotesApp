package com.example.quotesapp

sealed class Screens(val route: String) {
    object ScreenA: Screens("screen_a")
    object ScreenB: Screens("screen_b")
}