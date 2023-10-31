package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import org.springframework.context.annotation.Bean;

/*import com.example.domain.AppUser;
import com.example.domain.AppUserRepository;
import com.example.domain.Book;
import com.example.domain.BookRepository;
import com.example.domain.Category;
import com.example.domain.CategoryRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/

@SpringBootApplication
public class BookstoreApplication {
	//private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	/*@Bean(name = "bookCommandLineRunner")
	public CommandLineRunner bookCommandLineRunner(BookRepository repository) {
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
	public CommandLineRunner categoryCommandLineRunner(CategoryRepository repository) {
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

	@Bean(name = "appUserCommandLineRunner")
	public CommandLineRunner appUserCommandLineRunner(AppUserRepository repository) {
		return (args) -> {
			AppUser user1 = new AppUser("user", "$2a$10$0KjO/Sv1fLDOBXkFuTiRCuAjkhrEn/r8a3jXsCZYT.EmorAuLkHXS" , "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$/IF1J8rB2gFOokEkh22y/u2ixa4YsxRzEztplp3Ft9uJN8GbDZ3GS" ,
					"ADMIN");
			repository.save(user1);
			repository.save(user2);

			log.info("fetch * users");
			for (AppUser appUser : repository.findAll()) {
				log.info(appUser.toString());
			}
		};
	}*/
}
