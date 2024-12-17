package com.example.kotlin_classes.abschluss_abgabe.library

import com.example.kotlin_classes.abschluss_abgabe.models.Book
import com.example.kotlin_classes.abschluss_abgabe.models.Genre
import com.example.kotlin_classes.abschluss_abgabe.models.BookStatus

/**
 * The `LibraryManager` class organizes and manages library operations,
 * such as adding books, managing members, and displaying statuses.
 */
class LibraryManager {

    private val library = Library()

    /**
     * Sets up the library with an address and initial book collection.
     */
    fun setupLibrary() {
        println("========== Setting up the library ==========")
        val address = Library.LibraryAddress("Hausener Street 9", "Brackenheim", "74336")
        address.printAddress()

        addInitialBooks()
    }

    /**
     * Adds a predefined set of books to the library.
     */
    private fun addInitialBooks() {
        println("\n========== Adding books to the library ==========")
        val books = listOf(
            Book("Faust", "Johann Wolfgang von Goethe", Genre.FICTION, BookStatus.Available),
            Book("All Quiet on the Western Front", "Erich Maria Remarque", Genre.HISTORY, BookStatus.Available),
            Book("Harry Potter and the Philosopher's Stone", "J.K.Rowling", Genre.FANTASY, BookStatus.Available)
        )

        books.forEach { library.addBook(it) }
    }

    /**
     * Simulates library member actions like borrowing or reserving books.
     */
    fun simulateMemberActions() {
        println("\n========== Library Member Actions ==========")
        val member = library.LibraryMember("Luis", "L999")

        val faust = library.findBook("Faust").firstOrNull()
        faust?.let { member.checkoutBook(it, "2024-12-31") }

        val harryPotter = library.findBook("Harry Potter").firstOrNull()
        harryPotter?.let { member.reserveBook(it) }
    }

    /**
     * Displays the current status of all books in the library.
     */
    fun displayLibraryStatus() {
        println("\n========== Current book statuses ==========")
        library.displayAllBooks()
    }
}
