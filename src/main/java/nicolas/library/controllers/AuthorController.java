package nicolas.library.controllers;

import nicolas.library.model.Author;
import nicolas.library.repositories.AuthorRepository;
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

    @GetMapping("/AuthorList")
    public String showAuthorList(Model model) {
        List<Author> authors = authorRepository.findAll();
        model.addAttribute("authors", authorRepository.findAllOrderByName());
        return "AuthorList";
    }

    @GetMapping({"/AuthorDetails/{id}"})
    public String authorDetails(Model model, @PathVariable(required = false) Integer id) {
        Optional<Author> authorFromDb = authorRepository.findById(id);
        if (authorFromDb.isPresent()) {
            Author author = authorFromDb.get();
            model.addAttribute("author", author);
            model.addAttribute("books", author.getBooks());
        }
        return "AuthorDetails";
    }

    @GetMapping({"/AuthorDetails/{id}/prev"})
    public String showAuthorDetailsPrev(Model model, @PathVariable(required = false) Integer id){
        Optional<Author> prevAuthorFromDb = authorRepository.findFirstByIdLessThanOrderByIdDesc(id);
        if (prevAuthorFromDb.isPresent()){
            return String.format("redirect:/AuthorDetails/%d", prevAuthorFromDb.get().getId());}
        Optional<Author> lastAuthorFromDb = authorRepository.findFirstByOrderByIdDesc();
        if (lastAuthorFromDb.isPresent())
            return String.format("redirect:/AuthorDetails/%d", lastAuthorFromDb.get().getId());
        model.addAttribute("prevDisabled", true);
        model.addAttribute("nextDisabled", false);
        model.addAttribute("Author", authorRepository.findById(id).get());
        return "AuthorDetails";
    }

    @GetMapping({"/AuthorDetails/{id}/next"})
    public String showAuthorDetailsNext(Model model, @PathVariable(required = false) Integer id){
        Optional<Author> nextAuthorFromDb = authorRepository.findFirstByIdGreaterThanOrderByIdAsc(id);
        if (nextAuthorFromDb.isPresent())
            return String.format("redirect:/AuthorDetails/%d", nextAuthorFromDb.get().getId());
        Optional<Author> firstAuthorFromDb = authorRepository.findFirstByOrderByIdAsc();
        if (firstAuthorFromDb.isPresent())
            return String.format("redirect:/AuthorDetails/%d", firstAuthorFromDb.get().getId());
        return "AuthorDetails";
    }
}
