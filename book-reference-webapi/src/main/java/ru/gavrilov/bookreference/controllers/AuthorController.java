package ru.gavrilov.bookreference.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gavrilov.core.authors.model.Author;
import ru.gavrilov.core.authors.service.AuthorService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping()
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthor();
        return ResponseEntity.ok(authors);
    }

    @PostMapping("/create")
    public ResponseEntity<Author> createAuthor(@Valid @RequestBody Author author) {
        Author saveAuthor = authorService.createAuthor(author);
        return ResponseEntity.ok(saveAuthor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable(value = "id") Long authorId) {
        Author author = authorService.getAuthorById(authorId);

        return ResponseEntity.ok(author);
    }

    @PutMapping("/save/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable(value = "id") Long authorId,
                                           @Valid @RequestBody Author authorDetails) {
        Author updatedAuthor= authorService.updateAuthor(authorId, authorDetails);

        return ResponseEntity.ok(updatedAuthor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable(value = "id") Long authorId) {
        authorService.deleteAuthor(authorId);
        return ResponseEntity.ok().build();
    }

}
