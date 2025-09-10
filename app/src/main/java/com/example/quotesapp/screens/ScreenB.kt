package com.example.quotesapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.quotesapp.model.Quote
import com.example.quotesapp.viewmodel.QuoteViewModel

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun ScreenB(vm: QuoteViewModel, route: NavHostController) {
//    val quotes by vm.quotes.collectAsStateWithLifecycle()
//    val isLoading by vm.isLoading.collectAsStateWithLifecycle()
//    val RandomQuote by vm.randomQuote.collectAsStateWithLifecycle()
//    LaunchedEffect(key1 = Unit) {
//        vm.loadQuote()
//    }
//    Scaffold (
//        topBar = {
//            TopAppBar(
//                title = { Text("Quotes") },
//                navigationIcon = {
//                    IconButton(onClick = { route.popBackStack() }) {
//                        Icon(
//                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
//                            contentDescription = "Back",
//                            tint = MaterialTheme.colorScheme.onSurface
//                        )
//                    }
//                },
//                actions = {
//                    IconButton(onClick = { vm.shuffle() }) {
//                        Icon(Icons.Default.Refresh, contentDescription = "Refresh")
//                    }
//                }
//            )
//        },
//    ) {innerPadding->
//        //val valie = innerPadding
//
//        when{
//            isLoading-> {
//                Box(modifier = Modifier
//                    .fillMaxSize()
//                    .padding(innerPadding),
//                    contentAlignment = Alignment.Center
//                ){
//                    CircularProgressIndicator()
//                }
//            }
//        }
//        LazyColumn(
//            modifier = Modifier
//                .padding(innerPadding)
//                .fillMaxWidth()
//                .size(300.dp) // Use innerPadding
//        ) {
//            items(quotes) { quote ->
//                QuoteItem(quote)
//                HorizontalDivider(thickness = 0.5.dp, color = DividerDefaults.color)
//            }
//        }
//    }
//    Column () {
//        Box(modifier = Modifier.fillMaxWidth() ,contentAlignment = Alignment.BottomCenter){
//            Button(
//                onClick = {},
//                modifier = Modifier,
//            ) { Text("Random Quote") }
//        }
//    }
//}
//
//@Composable
//fun QuoteItem(quote: Quote) {
//    Column(modifier = Modifier.padding(vertical = 12.dp)) {
//        Text(text = "“${quote.text}”", style = MaterialTheme.typography.titleMedium)
//        Text(
//            text = "— ${quote.author}",
//            style = MaterialTheme.typography.bodyMedium
//        )
//    }
//}



//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun ScreenB(vm: QuoteViewModel, route: NavHostController) {
//    val quotes by vm.quotes.collectAsStateWithLifecycle()
//    val isLoading by vm.isLoading.collectAsStateWithLifecycle()
//    //val randomQuote by vm.randomQuote.collectAsStateWithLifecycle()
//
//    LaunchedEffect(key1 = Unit) {
//        vm.loadQuote()
//    }
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text("Quotes") },
//                navigationIcon = {
//                    IconButton(onClick = { route.popBackStack() }) {
//                        Icon(
//                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
//                            contentDescription = "Back",
//                            tint = MaterialTheme.colorScheme.onSurface
//                        )
//                    }
//                },
//                actions = {
//                    IconButton(onClick = { vm.shuffle() }) {
//                        Icon(Icons.Default.Refresh, contentDescription = "Refresh")
//                    }
//                }
//            )
//        },
//    ) { innerPadding ->
//        when {
//            isLoading -> {
//                Box(modifier = Modifier
//                    .fillMaxSize()
//                    .padding(innerPadding),
//                    contentAlignment = Alignment.Center
//                ) {
//                    CircularProgressIndicator()
//                }
//            }
//        }
//
//        LazyColumn(
//            modifier = Modifier
//                .padding(innerPadding)
//                .fillMaxWidth()
//                .size(300.dp) // Use innerPadding
//        ) {
//            items(quotes) { quote ->
//                QuoteItem(quote)
//                HorizontalDivider(thickness = 0.5.dp, color = DividerDefaults.color)
//            }
//        }
//
//        // Button to display a random quote below the LazyColumn
//        Column {
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp), contentAlignment = Alignment.Center
//            ) {
//                Button(
//                    onClick = {  },
//                    //onClick = { vm.loadRandomQuote() },
//                    modifier = Modifier.fillMaxWidth()
//                ) {
//                    Text("Random Quote")
//                }
//            }
//            // Show the random quote below the list
////            randomQuote?.let { quote ->
////                Box(
////                    modifier = Modifier
////                        .fillMaxWidth()
////                        .padding(16.dp),
////                    contentAlignment = Alignment.Center
////                ) {
////                    Column {
////                        Text(text = "Random Quote", style = MaterialTheme.typography.headlineMedium)
////                        Spacer(modifier = Modifier.height(8.dp))
////                        QuoteItem(quote)
////                    }
////                }
////            }
//        }
//    }
//}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenB(vm: QuoteViewModel, route: NavHostController) {
    val quotes by vm.quotes.collectAsStateWithLifecycle()
    val isLoading by vm.isLoading.collectAsStateWithLifecycle()
    val randomQuote by vm.randomQuote.collectAsStateWithLifecycle()
    val isRandomQuoteLoading by vm.isRandomQuoteLoading.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        vm.loadQuote()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Quotes") },
                navigationIcon = {
                    IconButton(onClick = { route.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { vm.shuffle() }) {
                        Icon(Icons.Default.Refresh, contentDescription = "Refresh")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when {
                isLoading -> {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                else -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),  // ✅ Key fix: takes available space but leaves room for bottom
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(quotes) { quote ->
                            QuoteItem(quote)
                            HorizontalDivider(
                                thickness = 0.5.dp,
                                color = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
                            )
                        }
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                // Random quote button
                Button(
                    onClick = { vm.loadRandomQuote() },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = !isRandomQuoteLoading
                ) {
                    if (isRandomQuoteLoading) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(16.dp),
                                strokeWidth = 2.dp
                            )
                            Text("Loading...")
                        }
                    } else {
                        Text("Get Random Quote")
                    }
                }

                randomQuote?.let { quote ->
                    Spacer(modifier = Modifier.height(16.dp))
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Random Quote",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )
                                IconButton(
                                    onClick = { vm.clearRandomQuote() },
                                    modifier = Modifier.size(24.dp)
                                ) {
                                    Icon(
                                        Icons.Default.Clear,
                                        contentDescription = "Clear",
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            QuoteItem(quote)
                        }
                    }
                }
            }
        }
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