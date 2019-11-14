package com.example.demo;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
public class BookController {

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        Adv5Application.books.add(book);
        book.setId(""+Adv5Application.books.size());
        return book;
    }

    @PutMapping
    public Book putBook(@RequestBody Book book) {
        Book newBook = Adv5Application.books.stream().filter(b -> b.getId().equals(book.getId())).findFirst().orElse(null);
        if (newBook == null){
            throw new BookNotFoundException();
        } else {
            newBook.setTitle(book.getTitle());
            newBook.setAuthors(book.getAuthors());
            newBook.setDate(book.getDate());
            return newBook;
        }

    }

    @GetMapping("/{bookTitle}")
    public Book getBook(@PathVariable("bookTitle") String bookTitle) {
        Book book = Adv5Application.books.stream().filter(b -> b.getTitle().equals(bookTitle)).findFirst().orElse(null);
        if (book == null ){
            throw new BookNotFoundException();
        }else {
            return book;
        }
    }

    @GetMapping("/list")
    public Object[] getBooks() {
        return Adv5Application.books.toArray();
    }

    @DeleteMapping("/delete/{bookTitle}")
    public Book deleteBook(@PathVariable("bookTitle") String bookTitle) {
        Book bo = Adv5Application.books.stream().filter(b -> b.getTitle().equals(bookTitle)).findFirst().orElse(null);
        Adv5Application.books.removeIf( book -> book.getTitle().equals(bookTitle));
        return bo;
    }
}
