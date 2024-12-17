package com.example.kotlin_classes.abschluss_abgabe.models

/**
 * The `Genre` enum class represents the various genres a book can belong to.
 * Each genre is associated with a descriptive string.
 *
 * @property description A brief description of the genre.
 */
enum class Genre(val description: String) {
    /**
     * Fictional stories and novels.
     */
    FICTION("Fictional stories and novels"),

    /**
     * Non-fictional books, factual and educational content.
     */
    NON_FICTION("Non-fiction books and factual content"),

    /**
     * Books about science, technology, and related fields.
     */
    SCIENCE("Books about science and technology"),

    /**
     * Books focused on historical events and topics.
     */
    HISTORY("Books about historical events and studies"),

    /**
     * Books intended for a younger audience, often educational or entertaining.
     */
    CHILDREN("Books for children and younger audiences"),

    /**
     * Fantasy books featuring magical, adventurous, and mythical elements.
     */
    FANTASY("Fantasy books with magic, adventures, and myths");

    /**
     * Prints the description of the genre to the console.
     */
    fun printDescription() {
        println("Genre: $name - $description")
    }
}
