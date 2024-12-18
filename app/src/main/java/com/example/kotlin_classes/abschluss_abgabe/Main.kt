package com.example.kotlin_classes.abschluss_abgabe

import com.example.kotlin_classes.abschluss_abgabe.library.LibraryManager
import com.example.kotlin_classes.abschluss_abgabe.models.Genre

/**
 * The main function is the entry point of the library application.
 * It initializes the library, sets up books, simulates member actions,
 * and displays the final status of all books.
 */
fun main() {

    // Create an instance of LibraryManager to handle library operations.
    val manager = LibraryManager()

    // Initialize the library: add books and set up the address.
    manager.setupLibrary()

    // Display all available genres with their descriptions.
    println("\n========== Genres ==========")
    Genre.values().forEach { genre ->
        genre.printDescription()
    }

    // Simulate actions performed by a library member.
    manager.simulateMemberActions()

    //  Display the final status of all books in the library.
    manager.displayLibraryStatus()
}
