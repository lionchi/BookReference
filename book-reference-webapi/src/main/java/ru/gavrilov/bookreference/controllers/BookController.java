package ru.gavrilov.bookreference.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gavrilov.core.books.model.Book;
import ru.gavrilov.core.repositories.BookRepositories;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookRepositories bookRepositories;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllNotes() {
        return ResponseEntity.ok(bookRepositories.findAll());
    }

    @PostMapping("/books")
    public ResponseEntity<Book> createNote(@Valid @RequestBody Book book) {
        Book saveBook = bookRepositories.save(book);
        return ResponseEntity.ok(saveBook);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getNoteById(@PathVariable(value = "id") Long bookId) {
        Book book = bookRepositories.findOne(bookId);
        if(book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @PutMapping("/books/save/{id}")
    public ResponseEntity<Book> updateNote(@PathVariable(value = "id") Long bookId,
                                           @Valid @RequestBody Book bookDetails) {
        Book book = bookRepositories.findOne(bookId);
        if(book == null) {
            return ResponseEntity.notFound().build();
        }
        book.setTitle(bookDetails.getTitle());
        book.setDescription((bookDetails.getDescription()));

        Book updatedBook = bookRepositories.save(book);
        return ResponseEntity.ok(updatedBook);
    }

/*    @DeleteMapping("/books/{id}")
    public ResponseEntity<Book> deleteNote(@PathVariable(value = "id") Long bookId) {
        Book book = bookRepositories.findOne(bookId);
        if(book == null) {
            return ResponseEntity.notFound().build();
        }

        bookRepositories.delete(book);
        return ResponseEntity.ok().build();
    }*/
}
