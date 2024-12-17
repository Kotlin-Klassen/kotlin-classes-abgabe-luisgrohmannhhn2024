package com.example.kotlin_classes.abschluss_abgabe.models

/**
 * The `Book` data class represents a book in the library.
 * It contains information about the book's title, author, genre, and current status.
 *
 * @param title The title of the book.
 * @param author The author of the book.
 * @param genre The genre of the book, represented by the `Genre` enum.
 * @param status The current status of the book, represented by the `BookStatus` sealed class.
 */
data class Book(
    val title: String,
    val author: String,
    val genre: Genre,
    var status: BookStatus
)
