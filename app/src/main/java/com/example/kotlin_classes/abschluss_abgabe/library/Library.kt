package com.example.kotlin_classes.abschluss_abgabe.library

import com.example.kotlin_classes.abschluss_abgabe.models.Book
import com.example.kotlin_classes.abschluss_abgabe.models.BookStatus

/**
 * The `Library` class represents a library and manages a collection of books.
 * It provides methods for managing books and includes `Nested` and `Inner Classes`.
 */
class Library {
    private val books = mutableListOf<Book>()

    /**
     * Adds a new book to the library.
     * @param book The book to be added.
     */
    fun addBook(book: Book) {
        books.add(book)
        println("Book added: '${book.title}' by ${book.author}")
    }

    /**
     * Searches for books based on title or author.
     * @param query The search keyword (part of the title or author).
     * @return A list of books that match the query.
     */
    fun findBook(query: String): List<Book> {
        val foundBooks = books.filter {
            it.title.contains(query, ignoreCase = true) || it.author.contains(query, ignoreCase = true)
        }
        println("Search for '$query' found ${foundBooks.size} book(s):")
        foundBooks.forEach { println("- ${it.title} by ${it.author}") }
        return foundBooks
    }

    /**
     * Displays the status of all books in the library.
     */
    fun displayAllBooks() {
        println("Current books in the library:")
        books.forEach { book ->
            println("${book.title} by ${book.author} - ${book.genre}: ${book.status.getStatusDescription()}")
        }
    }

    /**
     * The `LibraryAddress` class represents the address of the library.
     * This is a `Nested Class` and does not have access to the outer class instance.
     */
    class LibraryAddress(val street: String, val city: String, val zipCode: String) {
        /**
         * Prints the library's address.
         */
        fun printAddress() {
            println("Library Address: $street, $city, $zipCode")
        }
    }

    /**
     * The `LibraryMember` class represents a library member.
     * This is an `Inner Class` and has access to the book list of the library.
     */
    inner class LibraryMember(val name: String, val memberID: String) {
        /**
         * Checks out a book if it is available.
         * The book's status is updated to `CheckedOut`.
         * @param book The book to be checked out.
         * @param dueDate The due date for returning the book.
         */
        fun checkoutBook(book: Book, dueDate: String) {
            if (book.status is BookStatus.Available) {
                book.status = BookStatus.CheckedOut(dueDate, memberID)
                println("$name (Member ID: $memberID) checked out '${book.title}' until $dueDate.")
            } else {
                println("The book '${book.title}' is not available for checkout.")
            }
        }

        /**
         * Reserves a book if it is available.
         * The book's status is updated to `Reserved`.
         * @param book The book to be reserved.
         */
        fun reserveBook(book: Book) {
            if (book.status is BookStatus.Available) {
                book.status = BookStatus.Reserved(name, memberID)
                println("$name (Member ID: $memberID) reserved '${book.title}'.")
            } else {
                println("The book '${book.title}' cannot be reserved.")
            }
        }
    }
}
