package nicolas.library.controllers.admin;

import nicolas.library.model.*;
import nicolas.library.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        } else {
            logger.warn("Book with id " + id + " not found");
            return "redirect:/bookDetails/" + id;
        }

        List<Genre> allGenres = genreRepository.findAll();
        List<Author> allAuthors = authorRepository.findAll();
        List<Category> allCategories = categoryRepository.findAll();
        List<Status> allStatuses = statusRepository.findAll();

        model.addAttribute("allGenres", allGenres);
        model.addAttribute("allAuthors", allAuthors);
        model.addAttribute("allCategories", allCategories);
        model.addAttribute("allStatuses", allStatuses);

        return "admin/bookedit";
    }

//    @PostMapping("/bookedit/{id}")
//    public String BookEditPost(@PathVariable Integer id,
//                               Book book){
//        logger.info("BookEditPost " + id + " -- new book= " + book.getTitle() + ", new author = " + book.getAuthors() + ", new genre = " + book.getGenres() + ", new year = " + book.getRelease_year() + ", new description = " + book.getDescription());
//        booksRepository.save(book);
//        return "redirect:/BookDetails/" + id;
//    }
//
//    @GetMapping("/newbook")
//    public String NewBook(Model model){
//        logger.info("NewBook");
//        model.addAttribute("books", booksRepository.findAll());
//        return "admin/newbook";
//    }
//
//    @PostMapping("/newbook")
//    public String NewBookPost(Model model, Book book){
//        logger.info("NewBookPost -- new book = " + book.getTitle() + ", new author = " + book.getAuthors() + ", new genre = " + book.getGenres() + ", new year = " + book.getRelease_year() + ", new description = " + book.getDescription());
//        Book newBook = booksRepository.save(book);
//        return "redirect:/BookDetails/" + newBook.getId();
//    }
}
