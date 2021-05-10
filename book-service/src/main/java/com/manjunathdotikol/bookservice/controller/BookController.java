package com.manjunathdotikol.bookservice.controller;

import com.manjunathdotikol.bookservice.model.Book;
import com.manjunathdotikol.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriUtils;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/price/{price}")
    public List<Book> getBooksByPrice(@PathVariable("price") String price){
        return bookService.getBooksByPrice(price);
    }

    @GetMapping("/author/{name}")
    public List<Book> getBooksByAuthor(@PathVariable("name") String name) {
        String author = UriUtils.decode(name,"UTF-8");
        return bookService.getBooksByAuthor(author);
    }
}
