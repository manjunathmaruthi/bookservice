package com.manjunathdotikol.bookservice;

import com.manjunathdotikol.bookservice.controller.BookController;
import com.manjunathdotikol.bookservice.model.Book;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookserviceApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private BookController bookController;

	@Test
	void contextLoads() {
		assertThat(bookController).isNotNull();
	}

	@Test
	public void testGetAllBooks()  {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/books/",
				List.class)).asList();
	}

	@Test
	public void testGetAllBooksPrice_29()  {
		ResponseEntity<List<Book>> result =this.restTemplate.exchange("http://localhost:" + port + "/books/price/" + 29,
				HttpMethod.GET,null, new ParameterizedTypeReference<List<Book>>(){});

		List<Long> list = result.getBody().stream().map(book->book.getId()).collect(Collectors.toList());
		Assert.assertArrayEquals(list.toArray(),new Long[]{1l,2l,4l,5l});
	}

	@Test
	public void testGetAllBooksPrice_25()  {
		ResponseEntity<List<Book>> result =this.restTemplate.exchange("http://localhost:" + port + "/books/price/" + 25,
				HttpMethod.GET,null, new ParameterizedTypeReference<List<Book>>(){});
		List<Long> list = result.getBody().stream().map(book->book.getId()).collect(Collectors.toList());
		Assert.assertArrayEquals(list.toArray(),new Long[]{3l,4l});
	}

	//similary we can add for other end points
}
