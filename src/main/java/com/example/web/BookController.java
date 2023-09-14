package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Book;
import com.example.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;

	@RequestMapping(value = { "booklist" })
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

	@GetMapping(value = { "addbook" })
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}

	@PostMapping(value = "save")
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}

	@GetMapping(value = "/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id, Model model) {
		repository.deleteById(id);
		return "redirect:../booklist";
	}

	@RequestMapping(value = "/edit/{id}")
	public String showEditBook(@PathVariable("id") Long id, Model model){model.addAttribute("book", repository.findById(id));
	model.addAttribute("departments", repository.findAll());
	return "editbook";
	}
}
