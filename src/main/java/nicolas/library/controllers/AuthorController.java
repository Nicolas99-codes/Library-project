package nicolas.library.controllers;

import nicolas.library.model.Author;
import nicolas.library.repositories.AuthorRepository;
import nicolas.library.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping({"/AuthorDetails/{id}"})
    public String authorDetails(Model model, @PathVariable int id) {
        Optional<Author> AuthorFromDb = authorRepository.findById(id);
        if (AuthorFromDb.isPresent()) {
            model.addAttribute("author", AuthorFromDb.get());
        }
        return "AuthorDetails";
    }

    @GetMapping("/AuthorList")
    public String showAuthorList(Model model) {
        List<Author> authors = authorRepository.findAll();
        model.addAttribute("authors", authorRepository.findAllOrderByName());
        return "AuthorList";
    }
}
