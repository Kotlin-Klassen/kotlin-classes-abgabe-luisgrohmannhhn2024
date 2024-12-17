package com.example.kotlin_classes.abschluss_abgabe.models

/**
 * The `BookStatus` sealed class represents the current status of a book.
 * It defines three possible states: `Available`, `CheckedOut`, and `Reserved`.
 */
sealed class BookStatus {
    /**
     * Represents the state of a book being available for borrowing or reserving.
     */
    object Available : BookStatus()

    /**
     * Represents the state of a book that has been checked out by a library member.
     * @param dueDate The due date for returning the book.
     * @param memberID The ID of the member who checked out the book.
     */
    data class CheckedOut(val dueDate: String, val memberID: String) : BookStatus()

    /**
     * Represents the state of a book that has been reserved by a library member.
     * @param reservedBy The name of the member who reserved the book.
     * @param memberID The ID of the member who reserved the book.
     */
    data class Reserved(val reservedBy: String, val memberID: String) : BookStatus()

    /**
     * Provides a textual description of the current status of the book.
     * @return A string describing the book's status.
     */
    fun getStatusDescription(): String = when (this) {
        is Available -> "The book is available."
        is CheckedOut -> "The book is checked out until $dueDate (Member ID: $memberID)."
        is Reserved -> "The book is reserved by $reservedBy (Member ID: $memberID)."
    }
}
