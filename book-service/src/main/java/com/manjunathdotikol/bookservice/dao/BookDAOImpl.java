package com.manjunathdotikol.bookservice.dao;

import com.manjunathdotikol.bookservice.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl extends BookDAOAbstract implements BookDAO {


    @Override
    public List<Book> getAllBooks() {
       return getBooks();
    }

}
