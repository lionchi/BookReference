package ru.gavrilov.bookreference.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gavrilov.core.books.dto.BookDTO;
import ru.gavrilov.core.books.model.Book;
import ru.gavrilov.core.books.service.BookService;
import ru.gavrilov.core.mappers.BookMapper;
import ru.gavrilov.core.mappers.MapperFactory;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;
    private static final BookMapper bookMapper = MapperFactory.createMapper(BookMapper.class);

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<Book> books = bookService.getAllBook();
        List<BookDTO> bookDtoList = books.stream()
                .map((bookMapper::asBookDTO))
                .collect(Collectors.toList());
        return ResponseEntity.ok(bookDtoList);
    }

    @PostMapping("/create")
    public ResponseEntity<BookDTO> createBook(@Valid @RequestBody BookDTO book) {
        Book saveBook = bookService.createBook(book);
        BookDTO saveBookDto = bookMapper.asBookDTO(saveBook);
        return ResponseEntity.ok(saveBookDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable(value = "id") Long bookId) {
        Book book = bookService.getBookById(bookId);
        BookDTO bookDTO = bookMapper.asBookDTO(book);
        return ResponseEntity.ok(bookDTO);
    }

    @PutMapping("/save/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable(value = "id") Long bookId,
                                           @Valid @RequestBody BookDTO bookDetails) {
        Book updatedBook = bookService.updateBook(bookId,bookDetails);
        BookDTO updateBookDto = bookMapper.asBookDTO(updatedBook);
        return ResponseEntity.ok(updateBookDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.ok().build();
    }
}
