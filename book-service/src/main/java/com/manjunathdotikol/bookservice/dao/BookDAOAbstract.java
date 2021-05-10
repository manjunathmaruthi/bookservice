package com.manjunathdotikol.bookservice.dao;

import com.manjunathdotikol.bookservice.model.Book;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class BookDAOAbstract {

    protected List<Book> getBooks(){

        Book book1 = new Book(1,"Hyperion","Dan Simmons",
                "20");
        Book book2 = new Book(2,"A Fire Upon the Deep","Vernor Vinge",
                "13");
        Book book3 = new Book(3,"Harry Potter and the Goblet of Fire","J. K. Rowling",
                "31");
        Book book4 = new Book(4,"Ancillary Justice","Ann Leckie",
                "29");
        Book book5 = new Book(5,"A Deepness in the Sky","Vernor Vinge",
                "15");
        return Arrays.asList(book1,book2,book3,book4,book5);

    }


}
