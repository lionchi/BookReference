package ru.gavrilov.core.books.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gavrilov.core.books.model.Book;
import ru.gavrilov.core.repositories.BookRepositories;

import javax.annotation.Nonnull;
import java.util.List;

@Service
@Transactional
public class BookService {

    private BookRepositories bookRepositories;

    public BookService(@Nonnull BookRepositories bookRepositories) {
        this.bookRepositories = bookRepositories;
    }

    public List<Book> getAllBook (){
        return bookRepositories.findAll();
    }

    public Book createBook(@Nonnull Book book) {
        Book saveBook = bookRepositories.save(book);
        return saveBook;
    }

    public Book getBookById(@Nonnull Long bookId) {
        Book book = bookRepositories.findOne(bookId);
        if(book == null) {
            //return ResponseEntity.notFound().build(); надо обработать ошибку
        }
        return book;
    }

    public Book updateBook(@Nonnull Long bookId,
                           @Nonnull Book bookDetails) {
        Book book = bookRepositories.findOne(bookId);
        if(book == null) {
            //return ResponseEntity.notFound().build(); надо обработать ошибку
        }
        book.setTitle(bookDetails.getTitle());
        book.setDescription((bookDetails.getDescription()));

        Book updatedBook = bookRepositories.save(book);
        return updatedBook;
    }

    public void deleteBook(@Nonnull Long bookId) {
        Book book = bookRepositories.findOne(bookId);
        if(book == null) {
            //return ResponseEntity.notFound().build(); надо обработать ошибку
        }

        bookRepositories.delete(book);
    }
}
