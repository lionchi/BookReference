package ru.gavrilov.bookreference.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gavrilov.core.authors.dto.AuthorDTO;
import ru.gavrilov.core.authors.model.Author;
import ru.gavrilov.core.authors.service.AuthorService;
import ru.gavrilov.core.mappers.AuthorMapper;
import ru.gavrilov.core.mappers.MapperFactory;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private AuthorService authorService;
    private static final AuthorMapper authorMapper = MapperFactory.createMapper(AuthorMapper.class);

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping()
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthor();
        List<AuthorDTO> authorDtoList = authors.stream()
                .map((authorMapper::asAuthorDTO))
                .collect(Collectors.toList());
        return ResponseEntity.ok(authorDtoList);
    }

    @PostMapping("/create")
    public ResponseEntity<AuthorDTO> createAuthor(@Valid @RequestBody AuthorDTO author) {
        Author saveAuthor = authorService.createAuthor(author);
        AuthorDTO saveAuthorDto = authorMapper.asAuthorDTO(saveAuthor);
        return ResponseEntity.ok(saveAuthorDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable(value = "id") Long authorId) {
        Author author = authorService.getAuthorById(authorId);
        AuthorDTO authorDto = authorMapper.asAuthorDTO(author);
        return ResponseEntity.ok(authorDto);
    }

    @PutMapping("/save/{id}")
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable(value = "id") Long authorId,
                                           @Valid @RequestBody AuthorDTO authorDetails) {
        Author updatedAuthor= authorService.updateAuthor(authorId, authorDetails);
        AuthorDTO updateAuthorDto = authorMapper.asAuthorDTO(updatedAuthor);
        return ResponseEntity.ok(updateAuthorDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable(value = "id") Long authorId) {
        authorService.deleteAuthor(authorId);
        return ResponseEntity.ok().build();
    }

}
