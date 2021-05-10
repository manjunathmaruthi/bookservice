package com.manjunathdotikol.bookservice;

import com.manjunathdotikol.bookservice.dao.BookDAOImpl;
import com.manjunathdotikol.bookservice.model.Book;
import com.manjunathdotikol.bookservice.service.BookServiceImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceImplTest {

    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private BookDAOImpl mockedBookDAOImpl;

    private static List<Book> bookList = null;

    @BeforeClass
    public static void setup(){
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
        bookList = Arrays.asList(book1,book2,book3,book4,book5);

    }


    @Test
    public void testGetBooksByPrice_29() {
        Mockito.when(mockedBookDAOImpl.getAllBooks())
                .thenReturn(bookList);
        List<Book> result = bookService.getBooksByPrice("29");
        List<Long> list = result.stream().map(book->book.getId()).collect(Collectors.toList());
        Assert.assertArrayEquals(list.toArray(),new Long[]{1l,2l,4l,5l});
    }


    @Test
    public void testGetBooksByPrice_25() {
        Mockito.when(mockedBookDAOImpl.getAllBooks())
                .thenReturn(bookList);
        List<Book> result = bookService.getBooksByPrice("25");
        List<Long> list = result.stream().map(book->book.getId()).collect(Collectors.toList());
        Assert.assertArrayEquals(list.toArray(),new Long[]{3l,4l});
    }

    @Test
    public void testGetBooksByPrice_5() {
        List<Book> result = bookService.getBooksByPrice("5");
        Assert.assertEquals(result.size(),0);
    }

    @Test
    public void getBooksByAuthor_dan_simmons(){
        Mockito.when(mockedBookDAOImpl.getAllBooks())
                .thenReturn(bookList);
        List<Book> result = bookService.getBooksByAuthor("dan simmons");
        Assert.assertEquals(result.get(0).getId(),1);
    }

    @Test
    public void getBooksByAuthor_vernor_vinge(){
        Mockito.when(mockedBookDAOImpl.getAllBooks())
                .thenReturn(bookList);
        List<Book> result = bookService.getBooksByAuthor("vernor vinge");
        List<Long> list = result.stream().map(book->book.getId()).collect(Collectors.toList());
        Assert.assertArrayEquals(list.toArray(),new Long[]{2l,5l});
    }

    @Test
    public void getBooksByAuthor_vinge(){

        List<Book> result = bookService.getBooksByAuthor("vinge");
        Assert.assertEquals(result.size(),0);
    }

}
