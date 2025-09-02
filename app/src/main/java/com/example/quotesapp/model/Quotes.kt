package com.example.quotesapp.model

data class Quote(
    val text: String,
    val author: String
)

object QuotesDataSource{
    val quotesList = listOf(
        Quote("Be yourself; everyone else is already taken.", "Oscar Wilde"),
        Quote("Two things are infinite: the universe and human stupidity; and I'm not sure about the universe.", "Albert Einstein"),
        Quote("So many books, so little time.", "Frank Zappa"),
        Quote("A room without books is like a body without a soul.", "Marcus Tullius Cicero"),
        Quote("You only live once, but if you do it right, once is enough.", "Mae West"),
        Quote("Be the change that you wish to see in the world.", "Mahatma Gandhi"),
        Quote("In three words I can sum up everything I’ve learned about life: it goes on.", "Robert Frost"),
        Quote("If you tell the truth, you don't have to remember anything.", "Mark Twain"),
        Quote("A friend is someone who knows all about you and still loves you.", "Elbert Hubbard"),
        Quote("To live is the rarest thing in the world. Most people exist, that is all.", "Oscar Wilde"),
        Quote("Without music, life would be a mistake.", "Friedrich Nietzsche"),
        Quote("Always forgive your enemies; nothing annoys them so much.", "Oscar Wilde"),
        Quote("It is better to be hated for what you are than to be loved for what you are not.", "André Gide"),
        Quote("Life is what happens to us while we are making other plans.", "Allen Saunders"),
        Quote("We accept the love we think we deserve.", "Stephen Chbosky"),
        Quote("To be yourself in a world that is constantly trying to make you something else is the greatest accomplishment.", "Ralph Waldo Emerson"),
        Quote("I have not failed. I've just found 10,000 ways that won't work.", "Thomas A. Edison"),
        Quote("A journey of a thousand miles begins with a single step.", "Lao Tzu"),
        Quote("Happiness depends upon ourselves.", "Aristotle"),
        Quote("Turn your wounds into wisdom.", "Oprah Winfrey")
    )
}
