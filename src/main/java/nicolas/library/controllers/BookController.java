package nicolas.library.controllers;


import nicolas.library.model.Book;
import nicolas.library.model.Category;
import nicolas.library.model.Genre;
import nicolas.library.model.Status;
import nicolas.library.repositories.BooksRepository;
import nicolas.library.repositories.CategoryRepository;
import nicolas.library.repositories.GenreRepository;
import nicolas.library.repositories.StatusRepository;
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

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private StatusRepository statusRepository;


    @GetMapping({ "/BookDetails/{id}"})
    public String showBookDetails(Model model, @PathVariable int id) {
        Optional<Book> BookFromDb = booksRepository.findById(id);
        if (BookFromDb.isPresent()) {
            model.addAttribute("book", BookFromDb.get());
        }
        return "BookDetails";
    }

    @GetMapping({"/BookDetails/{id}/prev"})
    public String showBookDetailsPrev(Model model, @PathVariable int id){
        Optional<Book> prevBookFromDb = booksRepository.findFirstByIdLessThanOrderByIdDesc(id);
        if (prevBookFromDb.isPresent()){
            return String.format("redirect:/BookDetails/%d", prevBookFromDb.get().getId());}
        Optional<Book> lastBookFromDb = booksRepository.findFirstByOrderByIdDesc();
        if (lastBookFromDb.isPresent())
            return String.format("redirect:/BookDetails/%d", lastBookFromDb.get().getId());
        model.addAttribute("prevDisabled", true);
        model.addAttribute("nextDisabled", false);
        model.addAttribute("book", booksRepository.findById(id).get());
        return "BookDetails";
    }

    @GetMapping({"/BookDetails/{id}/next"})
    public String showBookDetailsNext(Model model, @PathVariable int id){
        Optional<Book> nextBookFromDb = booksRepository.findFirstByIdGreaterThanOrderByIdAsc(id);
        if (nextBookFromDb.isPresent())
            return String.format("redirect:/BookDetails/%d", nextBookFromDb.get().getId());
        Optional<Book> firstBookFromDb = booksRepository.findFirstByOrderByIdAsc();
        if (firstBookFromDb.isPresent())
            return String.format("redirect:/BookDetails/%d", firstBookFromDb.get().getId());
        return "BookDetails";
    }

    @GetMapping( "/BookList")
    public String showBookList(Model model) {
        List<Book> books = booksRepository.findAll();
        model.addAttribute("books", booksRepository.findAllOrderByTitle());
        model.addAttribute("showFilters", false);
        return "BookList";
    }

    @GetMapping("/BookList/Price/{filter}")
    public String showBookListByPrice(Model model, @PathVariable String filter) {
        logger.info("Show book list by price: filter=" + filter);

        // Retrieve books based on the price filter
        List<Book> books = booksRepository.findByPrice(filter);

        model.addAttribute("books", books);
        model.addAttribute("genres", genreRepository.findAll());
        model.addAttribute("statuss", statusRepository.findAll());
        model.addAttribute("showFilters", true);
        model.addAttribute("filterPrice", filter);

        return "BookList";
    }

    @GetMapping("/BookList/Status/{filter}")
    public String showBookListByStatus(Model model, @PathVariable String filter) {
        logger.info("Show book list by status: filter=" + filter);

        // Retrieve books based on the status filter
        List<Book> books = booksRepository.findByStatus(filter);

        model.addAttribute("books", books);
        model.addAttribute("genres", genreRepository.findAll());
        model.addAttribute("statuss", statusRepository.findAll());
        model.addAttribute("showFilters", true);
        model.addAttribute("filterStatus", filter);

        return "BookList";
    }

    @GetMapping("/BookList/Genre/{filter}")
    public String showBookListByGenre(Model model, @PathVariable String filter) {
        logger.info("Show book list by genre: filter=" + filter);

        // Retrieve books based on the genre filter
        List<Book> books = booksRepository.findByGenre(filter);

        model.addAttribute("books", books);
        model.addAttribute("genres", genreRepository.findAll());
        model.addAttribute("statuss", statusRepository.findAll());
        model.addAttribute("showFilters", true);
        model.addAttribute("filterGenre", filter);

        return "BookList";
    }

    @GetMapping("/BookList/ReleaseYear/{filter}")
    public String showBookListByReleaseYear(Model model, @PathVariable String filter) {
        logger.info("Show book list by Release year: filter=" + filter);

        // Convert the filter to an Integer
        Integer yearFilter = Integer.valueOf(filter);

        // Retrieve books based on the year filter
        List<Book> books = booksRepository.findByReleaseYear(yearFilter);

        model.addAttribute("books", books);
        model.addAttribute("genres", genreRepository.findAll());
        model.addAttribute("statuss", statusRepository.findAll());
        model.addAttribute("showFilters", true);
        model.addAttribute("filterYear", filter);

        return "BookList";
    }


    @GetMapping("/BookList/Title/{filter}")
    public String showBookListByName(Model model, @PathVariable String filter) {
        logger.info("Show book list by title: filter=" + filter);

        // Retrieve books based on the name filter
        List<Book> books = booksRepository.findByTitle(filter);

        model.addAttribute("books", books);
        model.addAttribute("genres", genreRepository.findAll());
        model.addAttribute("statuss", statusRepository.findAll());
        model.addAttribute("showFilters", true);
        model.addAttribute("filterName", filter);

        return "BookList";
    }




    @GetMapping("/BookRequest")
    public String showBookRequest(Model model) {
        return "BookRequest";
    }

    @PostMapping("/Book/Request")
    public String submitBookRequest(@ModelAttribute Book book, Model model) {
        logger.info(String.format("Book request: %s", book));
        model.addAttribute("bookRequest", book);
        return "BookRequest";
    }




}
