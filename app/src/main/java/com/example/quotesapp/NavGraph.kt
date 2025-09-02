package com.example.quotesapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quotesapp.screens.ScreenA
import com.example.quotesapp.screens.ScreenB

@Composable
fun QuotesNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screens.ScreenA.route){
        composable(Screens.ScreenA.route){
            ScreenA(vm = viewModel() , navController)
        }
        composable(Screens.ScreenB.route){
            ScreenB(vm = viewModel(), navController)
        }
    }
}