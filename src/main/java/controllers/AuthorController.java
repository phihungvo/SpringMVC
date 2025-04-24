package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import businessLogics.AuthorBL;
import javaBeans.Author;

@Controller
public class AuthorController {
	@RequestMapping("/authors")
	public String authors(Model model) {
		List<Author> authors = AuthorBL.getAuthors();
		model.addAttribute("authors", authors);
		return "authors";
	}
	@RequestMapping(path = "/add-author")
	public String addAuthor() {
		return "add-author";
	}
	@RequestMapping(path = "/add-author",method = RequestMethod.POST)
	public String addAuthor(@RequestParam(name = "name") String name) {
		Author at = new Author();
		at.setName(name);
		AuthorBL.addAuthor(at);
		return "redirect:/authors";
	}
	@RequestMapping(path = "/edit-author", method = RequestMethod.GET)
	public String editAuthor(Model model, @RequestParam(name = "id") int id) {
		Author at = AuthorBL.getAuthorById(id);
		model.addAttribute("at", at);
		return "edit-author";
	}
	@RequestMapping(path = "/edit-author", method = RequestMethod.POST)
	public String editAuthor(Author at) {
		AuthorBL.editAuthor(at);
		return "redirect:/authors";
	}
	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	public String deleteAuthor(@RequestParam(name = "idXoa") int[] idXoas) {
		for(int id:idXoas) {
			AuthorBL.delAuthor(id);
		}
		return "redirect:/authors";
	}
}
