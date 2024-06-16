package nicolas.library.controllers;


import nicolas.library.model.*;
import nicolas.library.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
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

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

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
            List<Status> statuses = statusRepository.findAll();
            List<String> authorCountries = authorRepository.findDistinctCountries();
            model.addAttribute("releaseYear", releaseYears);
            model.addAttribute("genres", genres);
            model.addAttribute("statuses", statuses);
            model.addAttribute("authorCountries", authorCountries);
        }

        return "BookList";
    }

    @GetMapping("/BookList/filter")
    public String showBookFilter(Model model,
                                 @RequestParam(required = false) String releaseYear,
                                 @RequestParam(required = false) String genre,
                                 @RequestParam(required = false) String status,
                                 @RequestParam(required = false) String authors){

        List<Book> books;

        if (releaseYear != null && !releaseYear.isEmpty()) {
            books = booksRepository.findByReleaseYear(releaseYear);
        }
        else if (genre != null && !genre.isEmpty()) {
            books = booksRepository.findByGenresGenreOrderByTitle(genre);
        }
        else if (status != null && !status.isEmpty()) {
            books = booksRepository.findByStatusStatusOrderByTitle(status);
        }
        else if (authors != null && !authors.isEmpty()) {
            books = booksRepository.findByAuthorsCountry(authors);
        }
        else {
            books = booksRepository.findAllOrderByTitle();
        }

        model.addAttribute("showFilters", true);
        model.addAttribute("books", books);

        List<String> releaseYears = booksRepository.findDistinctReleaseYear();
        List<Genre> genres = genreRepository.findAll();
        List<Status> statuses = statusRepository.findAll();
        List<String> authorCountries = authorRepository.findDistinctCountries();
        model.addAttribute("releaseYear", releaseYears);
        model.addAttribute("genres", genres);
        model.addAttribute("statuses", statuses);
        model.addAttribute("authorCountries", authorCountries);


        return "BookList";
    }

    @GetMapping({"/BookDetails/{id}", "/BookDetails"})
    public String showBookDetails(Model model, @PathVariable Integer id) {
        Optional<Book> bookOptional = booksRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            model.addAttribute("book", book);

            Collection<Genre> genres = book.getGenres();
            model.addAttribute("genres", genres);

            Optional<Author> authorOptional = authorRepository.findById(book.getAuthorId());
            authorOptional.ifPresent(author -> model.addAttribute("author", author));

            Optional<Status> statusOptional = statusRepository.findById(book.getStatusId());
            statusOptional.ifPresent(status -> model.addAttribute("status", status));

            Optional<Category> categoryOptional = categoryRepository.findById(book.getCategoryId());
            categoryOptional.ifPresent(category -> model.addAttribute("category", category));

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();

            Authentication authenticationAdmin = SecurityContextHolder.getContext().getAuthentication();
            boolean isAdmin = authenticationAdmin.getAuthorities().stream()
                    .anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"));
            model.addAttribute("isAdmin", isAdmin);

            Optional<AppUser> optionalUser = userRepository.findByUsername(currentPrincipalName);
            boolean isFavorite = optionalUser.isPresent() && optionalUser.get().getFavoriteBooks().contains(book);
            model.addAttribute("isFavorite", isFavorite);

        } else {
            return "redirect:/error";
        }
        return "BookDetails";
    }

    @GetMapping({"/BookDetails/{id}/prev"})
    public String showBookDetailsPrev(Model model, @PathVariable Integer id){
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
    public String showBookDetailsNext(Model model, @PathVariable Integer id){
        Optional<Book> nextBookFromDb = booksRepository.findFirstByIdGreaterThanOrderByIdAsc(id);
        if (nextBookFromDb.isPresent())
            return String.format("redirect:/BookDetails/%d", nextBookFromDb.get().getId());
        Optional<Book> firstBookFromDb = booksRepository.findFirstByOrderByIdAsc();
        if (firstBookFromDb.isPresent())
            return String.format("redirect:/BookDetails/%d", firstBookFromDb.get().getId());
        return "BookDetails";
    }

    @PostMapping("/addFavorite/{id}")
    public String addFavorite(@PathVariable Integer id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/user/login";
        }

        String currentPrincipalName = authentication.getName();

        Optional<AppUser> optionalUser = userRepository.findByUsername(currentPrincipalName);
        if (optionalUser.isPresent()) {
            AppUser user = optionalUser.get();

            Optional<Book> optionalBook = booksRepository.findById(id);
            if (optionalBook.isPresent()) {
                Book book = optionalBook.get();
                user.getFavoriteBooks().add(book);
                userRepository.save(user);
            } else {
                logger.error("Book not found with id: " + id);
            }
        } else {
            logger.error("User not found with username: " + currentPrincipalName);
        }

        return "redirect:/BookDetails/" + id;
    }

    @PostMapping("/removeFavorite/{id}")
    public String removeFavorite(@PathVariable Integer id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/user/login";
        }

        String currentPrincipalName = authentication.getName();

        Optional<AppUser> optionalUser = userRepository.findByUsername(currentPrincipalName);
        if (optionalUser.isPresent()) {
            AppUser user = optionalUser.get();

            Optional<Book> optionalBook = booksRepository.findById(id);
            if (optionalBook.isPresent()) {
                Book book = optionalBook.get();
                user.getFavoriteBooks().remove(book);
                userRepository.save(user);
            } else {
                logger.error("Book not found with id: " + id);
            }
        } else {
            logger.error("User not found with username: " + currentPrincipalName);
        }

        return "redirect:/BookDetails/" + id;
    }

    @PostMapping("/removeFavoriteFromProfile/{id}")
    public String removeFavoriteFromProfile(@PathVariable Integer id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/user/login";
        }

        String currentPrincipalName = authentication.getName();

        Optional<AppUser> optionalUser = userRepository.findByUsername(currentPrincipalName);
        if (optionalUser.isPresent()) {
            AppUser user = optionalUser.get();

            Optional<Book> optionalBook = booksRepository.findById(id);
            if (optionalBook.isPresent()) {
                Book book = optionalBook.get();
                user.getFavoriteBooks().remove(book);
                userRepository.save(user);
            } else {
                logger.error("Book not found with id: " + id);
            }
        } else {
            logger.error("User not found with username: " + currentPrincipalName);
        }

        return "redirect:/profielPagina";
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
