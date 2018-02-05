package ru.gavrilov.bookreference.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gavrilov.core.books.model.Book;
import ru.gavrilov.core.books.service.BookService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllNotes() {
        List<Book> books = bookService.getAllBook();
        return ResponseEntity.ok(books);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> createNote(@Valid @RequestBody Book book) {
        Book saveBook = bookService.createBook(book);
        return ResponseEntity.ok(saveBook);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getNoteById(@PathVariable(value = "id") Long bookId) {
        Book book = bookService.getBookById(bookId);

        return ResponseEntity.ok(book);
    }

    @PutMapping("/books/save/{id}")
    public ResponseEntity<Book> updateNote(@PathVariable(value = "id") Long bookId,
                                           @Valid @RequestBody Book bookDetails) {
        Book updatedBook = bookService.updateBook(bookId,bookDetails);

        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Book> deleteNote(@PathVariable(value = "id") Long bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.ok().build();
    }
}
