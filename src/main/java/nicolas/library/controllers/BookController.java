package nicolas.library.controllers;


import nicolas.library.model.Book;
import nicolas.library.repositories.BooksRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
public class BookController {
    private Logger logger = LoggerFactory.getLogger(BookController.class);
    @Autowired
    private BooksRepository booksRepository;

    @GetMapping({ "/BookDetails/{id}"})
    public String showBookDetails(Model model, @PathVariable int id) {
        Optional<Book> BookFromDb = booksRepository.findById(id);
        if (BookFromDb.isPresent()) {
            model.addAttribute("book", BookFromDb.get());
        }
        return "BookDetails";
    }

    @GetMapping( "/BookList")
    public String showBookList(Model model) {
        List<Book> books = booksRepository.findAll();
        model.addAttribute("books", booksRepository.findAllOrderByTitle());
        model.addAttribute("showFilters", false);
        return "BookList";
    }

    @GetMapping("/BookList/filter")
    public String showBookFilter(Model model,
                                 @RequestParam(required = false) String genre,
                                 @RequestParam(required = false) String status) {
        logger.info(String.format("Show book filter: genre= %s, status= %s", genre, status));
        List<Book> bookFilter = booksRepository.findByFilter(genre, status);
        List<Book> books = booksRepository.findAll();
        model.addAttribute("books", books);
        model.addAttribute("bookFilter", bookFilter);
        model.addAttribute("genre", genre);
        model.addAttribute("status", status);
        model.addAttribute("showFilters", true);
        return "BookList";
    }

    @GetMapping("/BookRequest")
    public String showBookRequest(Model model) {
        return "BookRequest";
    }

    @PostMapping("/Book/Request")
    public String submitBookRequest(@ModelAttribute Book book) {
        logger.info(String.format("Book request: %s", book));
        return "BookRequest";
    }

    @GetMapping("/BookCategory")
    public String showBookCategory(Model model) {
        return "BookCategory";
    }
}
