package nicolas.library.controllers.admin;

import jakarta.validation.Valid;
import nicolas.library.model.*;
import nicolas.library.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class BookAdminController {

    private final Logger logger = LoggerFactory.getLogger(BookAdminController.class);
    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @ModelAttribute("book")
    public Book findBook(@PathVariable(required = false) Integer id){
        logger.info("findBook called with id: " + id);
        if (id == null) return new Book();

        Optional<Book> optionalBook = booksRepository.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            logger.warn("Book with id " + id + " not found");
            return new Book();
        }
    }

    @GetMapping({"/bookedit/{id}", "/bookedit"})
    public String BookEdit(Model model, @PathVariable(required = false) Integer id){
        if (id == null) {
            return "redirect:/bookDetails";
        }

        Optional<Book> currentBookFromDb = booksRepository.findById(id);

        if (currentBookFromDb.isPresent()) {
            Book currentBook = currentBookFromDb.get();
            model.addAttribute("book", currentBook);

            List<Author> authors = authorRepository.findAll();
            List<Genre> genres = genreRepository.findAll();
            List<Status> statuses = statusRepository.findAll();
            List<Category> categories = categoryRepository.findAll();

            model.addAttribute("authors", authors);
            model.addAttribute("genres", genres);
            model.addAttribute("statuses", statuses);
            model.addAttribute("categories", categories);

        } else {
            logger.warn("Book with id " + id + " not found");
            return "redirect:/bookDetails/" + id;
        }

        return "admin/bookedit";
    }

    @PostMapping("/bookedit/{id}")
    public String BookEditPost(@PathVariable(required = false) Integer id,
                               @Valid Book book,
                               BindingResult result,
                               Model model) {

        if (result.hasErrors()) {
            return "admin/bookedit";
        }


        booksRepository.save(book);


        return "redirect:/BookDetails/" + id;
    }



    @GetMapping("/newbook")
    public String NewBook(Model model) {
        logger.info("NewBook");

        List<Author> authors = authorRepository.findAll();
        List<Genre> genres = genreRepository.findAll();
        List<Status> statuses = statusRepository.findAll();
        List<Category> categories = categoryRepository.findAll();


        if (authors.isEmpty()) {
            authors.add(new Author());
        }

        model.addAttribute("authors", authors);
        model.addAttribute("genres", genres);
        model.addAttribute("statuses", statuses);
        model.addAttribute("categories", categories);

        model.addAttribute("book", new Book());

        return "admin/newbook";
    }


    @PostMapping("/newbook")
    public String NewBookPost(@Valid Book book, BindingResult result, Model model,
                              @RequestParam String author_name,
                              @RequestParam String author_surname,
                              @RequestParam String author_country) {
        if (result.hasErrors()) {
            List<Author> authors = authorRepository.findAll();
            List<Genre> genres = genreRepository.findAll();
            List<Status> statuses = statusRepository.findAll();
            List<Category> categories = categoryRepository.findAll();

            model.addAttribute("authors", authors);
            model.addAttribute("genres", genres);
            model.addAttribute("statuses", statuses);
            model.addAttribute("categories", categories);

            return "admin/newbook";
        }

        Author author = new Author();
        author.setAuthor_name(author_name);
        author.setSurname(author_surname);
        author.setCountry(author_country);


        Author savedAuthor = authorRepository.save(author);


        List<Author> authors = new ArrayList<>();
        authors.add(savedAuthor);


        book.setAuthors(authors);

        Book newBook = booksRepository.save(book);

        return "redirect:/BookDetails/" + newBook.getId();
    }





}
