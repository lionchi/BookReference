package ru.gavrilov.core.books.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gavrilov.core.abstracts.Guard;
import ru.gavrilov.core.books.dto.BookDTO;
import ru.gavrilov.core.books.model.Book;
import ru.gavrilov.core.mappers.BookMapper;
import ru.gavrilov.core.mappers.MapperFactory;
import ru.gavrilov.core.repositories.BookRepositories;

import javax.annotation.Nonnull;
import java.util.List;

@Service
@Transactional
public class BookService {

    private BookRepositories bookRepositories;
    private static final BookMapper bookMapper = MapperFactory.createMapper(BookMapper.class);

    public BookService(@Nonnull BookRepositories bookRepositories) {
        this.bookRepositories = bookRepositories;
    }

    public List<Book> getAllBook (){
        return bookRepositories.findAll();
    }

    public Book createBook(@Nonnull BookDTO bookDto) {
        Book book = bookMapper.asBook(bookDto);
        Book saveBook = bookRepositories.save(book);
        return saveBook;
    }

    public Book getBookById(@Nonnull Long bookId) {
        Book book = bookRepositories.findOne(bookId);
        Guard.notNull(book,"Такой книги не существует");
        return book;
    }

    public Book updateBook(@Nonnull Long bookId,
                           @Nonnull BookDTO bookDetails) {
        Book book = bookRepositories.findOne(bookId);
        Guard.notNull(book,"Такой книги не существует");
        book.setTitle(bookDetails.getTitle());
        book.setDescription((bookDetails.getDescription()));

        Book updatedBook = bookRepositories.save(book);
        return updatedBook;
    }

    public void deleteBook(@Nonnull Long bookId) {
        Book book = bookRepositories.findOne(bookId);
        Guard.notNull(book,"Такой книги не существует");
        bookRepositories.delete(book);
    }
}
