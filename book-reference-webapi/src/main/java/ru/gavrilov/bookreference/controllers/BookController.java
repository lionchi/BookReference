package ru.gavrilov.bookreference.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gavrilov.core.books.model.Book;
import ru.gavrilov.core.books.service.BookService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBook();
        return ResponseEntity.ok(books);
    }

    @PostMapping("/create")
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
        Book saveBook = bookService.createBook(book);
        return ResponseEntity.ok(saveBook);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Long bookId) {
        Book book = bookService.getBookById(bookId);

        return ResponseEntity.ok(book);
    }

    @PutMapping("/save/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable(value = "id") Long bookId,
                                           @Valid @RequestBody Book bookDetails) {
        Book updatedBook = bookService.updateBook(bookId,bookDetails);

        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable(value = "id") Long bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.ok().build();
    }
}
