package nicolas.library.controllers;


import nicolas.library.model.Book;
import nicolas.library.model.Genre;
import nicolas.library.repositories.BooksRepository;
import nicolas.library.repositories.GenreRepository;
import nicolas.library.repositories.StatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @GetMapping("/BookList")
    public String showBookList(Model model,
                               @RequestParam(value = "showFilters", required = false, defaultValue = "false") boolean showFilters,
                               @RequestParam(value = "search", required = false) String search,
                               @RequestParam(value = "genre", required = false) String genre) {

        List<Book> books;

        if (search != null && !search.isEmpty()) {
            books = booksRepository.findByTitleContainingIgnoreCaseOrderByTitle(search);
        } else if (genre != null && !genre.isEmpty()) {
            books = booksRepository.findByGenresGenreOrderByTitle(genre);
        } else {
            books = booksRepository.findAllOrderByTitle();
        }

        model.addAttribute("books", books);
        model.addAttribute("showFilters", showFilters);
        model.addAttribute("search", search);

        if (showFilters) {
            List<String> releaseYears = booksRepository.findDistinctReleaseYear();
            List<Genre> genres = genreRepository.findAll();
            model.addAttribute("releaseYear", releaseYears);
            model.addAttribute("genres", genres);
        }

        return "BookList";
    }

    @GetMapping("/BookList/filter")
    public String showBookFilter(Model model, @RequestParam(required = false) String releaseYear,
                                 @RequestParam(required = false) String genre) {

        List<Book> books;

        if (releaseYear != null && !releaseYear.isEmpty()) {
            books = booksRepository.findByReleaseYear(releaseYear);
        }
        else if (genre != null && !genre.isEmpty()) {
            books = booksRepository.findByGenresGenreOrderByTitle(genre);
        }
        else {
            books = booksRepository.findAllOrderByTitle();
        }

        model.addAttribute("showFilters", true);
        model.addAttribute("books", books);

        List<String> releaseYears = booksRepository.findDistinctReleaseYear();
        List<Genre> genres = genreRepository.findAll();
        model.addAttribute("releaseYear", releaseYears);
        model.addAttribute("genres", genres);

        // Return the view name
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
