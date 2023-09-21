package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.domain.Book;
import com.example.domain.BookRepository;
import com.example.domain.Category;
import com.example.domain.CategoryRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean(name = "bookCommandLineRunner")
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			repository.save(new Book("testi", "test", 1997, 1928, 44));
			repository.save(new Book("test", "testi", 1998, 1927, 99));

			log.info("fetch * books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};

	}

	@Bean(name = "categoryCommandLineRunner")
	public CommandLineRunner demo(CategoryRepository repository) {
		return (args) -> {
			repository.save(new Category("Scifi"));
			repository.save(new Category("Action"));
			repository.save(new Category("Horror"));

			log.info("fetch * categories");
			for (Category category : repository.findAll()) {
				log.info(category.toString());
			}
		};
	}
}
