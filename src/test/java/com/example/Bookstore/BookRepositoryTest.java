package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Book;
import com.example.domain.BookRepository;

import com.example.domain.Category;
import com.example.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	private BookRepository repository;

	@Autowired
	private CategoryRepository crepository;

	@Test
	public void findByTitleShouldReturnPrice() {
		List<Book> books = repository.findByTitle("testi");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getPrice()).isEqualTo(44);
	}

	@Test
	public void findByTitleShouldReturnAuthor() {
		List<Book> books = repository.findByTitle("test");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("testi");
	}

	@Test
	public void createNewBook() {
		Book book = new Book("junit testaus", "ada lovelace", 1800, 8181, 80);
		repository.save(book);
		assertThat(book.getId()).isNotNull();

	}

	@Test
	public void deleteBook() {
		List<Book> books = repository.findByTitle("testi");
		assertThat(books).hasSize(1);
		Book deleteThisBook = (books.get(0));
		repository.delete(deleteThisBook);
		List<Book> books2 = repository.findByTitle("testi");
		assertThat(books2).hasSize(0);
	}
	
	@Test
	void findAllBooksShouldReturnTwoRows() {
		Iterable<Book> books = repository.findAll();
		assertThat(books).hasSize(2);
	}

	@Test
	public void findByNameShouldReturnId() {
		List<Category> cats = crepository.findByName("Action");
		assertThat(cats).hasSize(1);
		assertThat(cats.get(0).getId());
	}

	@Test
	public void editCategory() {
		List<Book> books = repository.findByTitle("test");
		assertThat(books).hasSize(1);
		Book editThisBooksCategory = books.get(0);
		List<Category> cat = crepository.findByName("Horror");
		assertThat(cat).hasSize(1);
		editThisBooksCategory.setCategory(cat.get(0));
		repository.save(editThisBooksCategory);
		List<Book> books2 = repository.findByTitle("test");
		assertThat(books2).hasSize(1);
		assertThat(books2.get(0).getCategory().getName()).isEqualTo("Horror");
	}
}
