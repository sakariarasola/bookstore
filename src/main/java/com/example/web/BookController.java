package com.example.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Book;
import com.example.domain.BookRepository;
import com.example.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;

	@Autowired
	private CategoryRepository crepository;

	public BookController(BookRepository repository, CategoryRepository crepository) {
		this.repository = repository;
		this.crepository = crepository;
	}

	@RequestMapping(value = { "booklist" })
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

	@RequestMapping(value = { "login" })
	public String login(Model model) {
		return "redirect:booklist";
	}

	@GetMapping(value = { "books" })
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) repository.findAll();
	}

	@GetMapping(value = "book/{id}")
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
		return repository.findById(bookId);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = { "addbook" })
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}

	@PostMapping(value = "save")
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id, Model model) {
		repository.deleteById(id);
		return "redirect:../booklist";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/edit/{id}")
	public String showEditBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", repository.findById(id));
		model.addAttribute("categories", crepository.findAll());
		return "editbook";
	}
}
