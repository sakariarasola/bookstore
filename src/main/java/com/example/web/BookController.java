package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
	@RequestMapping("/index")
	public String book(@RequestParam(name = "title") String title, Model model) {
		model.addAttribute("title", title);
		return "index";
	}
}
