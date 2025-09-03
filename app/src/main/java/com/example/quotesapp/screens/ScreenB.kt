package com.example.quotesapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.quotesapp.model.Quote
import com.example.quotesapp.viewmodel.QuoteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenB(vm: QuoteViewModel, route: NavHostController) {
    val quotes by vm.quotes.collectAsStateWithLifecycle()
    val isLoading by vm.isLoading.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = Unit) {
        vm.loadQuote()
    }
    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text("Quotes") },
                navigationIcon = {
                    IconButton(onClick = { route.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { vm.shuffle() }) {
                        Icon(Icons.Default.Refresh, contentDescription = "Refresh")
                    }
                }
            )
        },
    ) {innerPadding->
        //val valie = innerPadding

        when{
            isLoading-> {
                Box(modifier = Modifier.fillMaxSize().padding(innerPadding),
                    contentAlignment = Alignment.Center
                ){
                    CircularProgressIndicator()
                }
            }
        }
        LazyColumn(
                    modifier = Modifier.padding(innerPadding) // Use innerPadding
                ) {
                    items(quotes) { quote ->
                        QuoteItem(quote)
                        HorizontalDivider(thickness = 0.5.dp, color = DividerDefaults.color)
                    }
                }

//        when{
//            isLoading-> {
//                Box(modifier = Modifier.fillMaxSize().padding(innerPadding),
//                    contentAlignment = Alignment.Center
//                ){
//                    CircularProgressIndicator()
//                }
//            }
//            quotes.isEmpty() ->{
//                Box(modifier = Modifier.fillMaxSize().padding(innerPadding),
//                    contentAlignment = Alignment.Center
//                ){
//                    Text("No quote available..")
//                }
//            }
//            else -> {
//                LazyColumn(
//                    modifier = Modifier.padding(innerPadding) // Use innerPadding
//                ) {
//                    items(quotes) { quote ->
//                        QuoteItem(quote)
//                        HorizontalDivider(thickness = 0.5.dp, color = DividerDefaults.color)
//                    }
//                }
//            }
//        }
    }
}

@Composable
fun QuoteItem(quote: Quote) {
    Column(modifier = Modifier.padding(vertical = 12.dp)) {
        Text(text = "“${quote.text}”", style = MaterialTheme.typography.titleMedium)
        Text(
            text = "— ${quote.author}",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
