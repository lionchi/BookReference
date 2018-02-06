package ru.gavrilov.core.books.service;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.gavrilov.core.books.model.Book;
import ru.gavrilov.core.repositories.BookRepositories;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
    @Mock
    private BookRepositories bookRepositories;
    @InjectMocks
    private BookService bookService;

    @Test
    public void getAllBook() throws Exception {
        when(bookRepositories.findAll()).thenReturn(ImmutableList.of());
        List<Book> books = bookService.getAllBook();
        verify(bookRepositories).findAll();
    }

    @Test
    public void createBook() throws Exception {
    }

    @Test
    public void getBookById() throws Exception {
    }

    @Test
    public void updateBook() throws Exception {
    }

    @Test
    public void deleteBook() throws Exception {
    }

}