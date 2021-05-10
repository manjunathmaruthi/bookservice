package com.manjunathdotikol.bookservice.service;

import com.manjunathdotikol.bookservice.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    List<Book> getBooksByPrice(String price);

    List<Book> getBooksByAuthor(String author);






}
