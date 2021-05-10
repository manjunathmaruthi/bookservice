package com.manjunathdotikol.bookservice.service;

import com.manjunathdotikol.bookservice.dao.BookDAO;
import com.manjunathdotikol.bookservice.exception.BookNotFoundException;
import com.manjunathdotikol.bookservice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    @Override
    public List<Book> getBooksByPrice(String price) {

        int inputPrice = Integer.parseInt(price);
        if(inputPrice <= 5){
            return new ArrayList<>();
        } else if(inputPrice >= 25 && inputPrice <=28){
            return getBooksHigherOrEqualAmount();
        } else if(inputPrice <=29) {
            return getBooksLowerOREqualAmount();
        } else {
            throw new BookNotFoundException(String.format("No book found for price: %s",price));
        }

    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        List<Book> bookResult = null;
        switch(author){
            case "dan simmons" : bookResult = bookDAO.getAllBooks().stream()
                    .filter(book->book.getId()==1)
                    .collect(Collectors.toList());
                break;
            case "vernor vinge": bookResult = bookDAO.getAllBooks().stream()
                    .filter(book->book.getId() == 2 || book.getId() == 5)
                    .collect(Collectors.toList());
                break;
            case "vinge" : bookResult = new ArrayList<>();
                break;
            default: throw new BookNotFoundException(String.format("No book with author : %s",author));

        }
        return bookResult;
    }

    private List<Book> getBooksHigherOrEqualAmount(){
        return bookDAO.getAllBooks().stream()
                .filter(book-> book.getId()== 3 || book.getId() == 4)
                .collect(Collectors.toList());
    }

    public List<Book> getBooksLowerOREqualAmount() {
        return bookDAO.getAllBooks().stream().filter(book-> book.getId() != 3)
                .collect(Collectors.toList());
    }
}
