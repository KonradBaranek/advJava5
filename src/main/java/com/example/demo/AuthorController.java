package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @PostMapping
    public Author addAuthor(@RequestBody Author author) {
        Adv5Application.authors.add(author);
        author.setId(""+Adv5Application.authors.size());
        return author;
    }

    @PutMapping
    public Author putAuthor(@RequestBody Author author) {
        Author newAuthor = Adv5Application.authors.stream().filter(b -> b.getId().equals(author.getId())).findFirst().orElse(null);
        if (newAuthor == null){
            throw new AuthorNotFoundException();
        } else {
            newAuthor.setName(author.getName());
            newAuthor.setSurname(author.getSurname());
            newAuthor.setBooks(author.getBooks());
            return newAuthor;
        }

    }

    @GetMapping("/{authorName}")
    public Author getAuthor(@PathVariable("authorName") String authorName) {
        Author author = Adv5Application.authors.stream().filter(b -> b.getName().concat(b.getSurname()).contains(authorName)).findFirst().orElse(null);
        if (author == null ){
            throw new AuthorNotFoundException();
        }else {
            return author;
        }
    }

    @GetMapping("/list")
    public Object[] getAuthors() {
        return Adv5Application.authors.toArray();
    }

    @DeleteMapping("/delete/{authorName}")
    public Author deleteAuthor(@PathVariable("authorName") String authorName) {
        Author bo = Adv5Application.authors.stream().filter(b -> b.getName().concat(b.getSurname()).contains(authorName)).findFirst().orElse(null);
        Adv5Application.authors.removeIf( author -> author.getName().concat(author.getSurname()).contains(authorName));
        return bo;
    }
}
