package ru.gavrilov.core.users.service;

import fr.xebia.extras.selma.Selma;
import org.junit.Test;
import ru.gavrilov.core.mappers.AuthorMapper;
import ru.gavrilov.core.mappers.BookMapper;
import ru.gavrilov.core.authors.dto.AuthorDTO;
import ru.gavrilov.core.authors.model.Author;
import ru.gavrilov.core.books.dto.BookDTO;
import ru.gavrilov.core.books.model.Book;
import ru.gavrilov.core.mappers.UserMapper;
import ru.gavrilov.core.users.dto.UserDTO;
import ru.gavrilov.core.users.model.User;

import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.*;

public class DtoMappedUnitTest {

    @Test
    public void testSelmaBookDto() {
        // Get SelmaMapper
        BookMapper mapper = Selma.builder(BookMapper.class).build();

        // Map my InBean
        User user = new User("Иванов Иван Иванович","ivan","545454","test@mail.ru",false,new Date());
        user.setId(1L);

        Book book = new Book("Бегущий человек","Человек который бегает","1960",user);
        BookDTO res = mapper.asBookDTO(book);

        assertNotNull(res);

        BookDTO response = new BookDTO();
        response.setTitle("Банан");

        Book resTwo = mapper.asBook(response);

       assertNotNull(resTwo);
    }

    @Test
    public void testSelmaAuthorDto() {
        // Get SelmaMapper
        AuthorMapper mapperAuthor = Selma.builder(AuthorMapper.class).build();
        BookMapper mapperBook = Selma.builder(BookMapper.class).build();

        // Map my InBean
        User user = new User("Иванов Иван Иванович", "ivan", "545454", "test@mail.ru", false, new Date());
        user.setId(1L);

        BookDTO bookDTO = new BookDTO();
        bookDTO.setDescription("Бла-Бла-Бла");
        bookDTO.setUserId(6L);
        bookDTO.setYearOfPublication("1960");
        bookDTO.setTitle("Банан");

        Book book = mapperBook.asBook(bookDTO);
        book.setUser(user);

        Author author = new Author("Татьяна Белова");
        author.setBooks(Arrays.asList(book));

        AuthorDTO res = mapperAuthor.asAuthorDTO(author);

        assertNotNull(res);
    }

    @Test
    public void testSelmaUserDto() {
        // Get SelmaMapper
        UserMapper mapper = Selma.builder(UserMapper.class).build();

        // Map my InBean
        User user = new User("Иванов Иван Иванович", "ivan", "545454", "test@mail.ru", false, new Date());
        user.setId(1L);
        user.setBooks(Arrays.asList(new Book()));

        UserDTO userDTO = mapper.asUserDTO(user);

        assertNotNull(userDTO);

        UserDTO newUserDTO = new UserDTO();
        newUserDTO.setFullName("Вася");
        newUserDTO.setEmail("test@mail.ru");
        newUserDTO.setLogin("test");
        newUserDTO.setPassword("545454");
        newUserDTO.setDateOfRegistration(new Date());

        User newUser = mapper.asUser(newUserDTO);

        assertNotNull(newUser);
    }

}