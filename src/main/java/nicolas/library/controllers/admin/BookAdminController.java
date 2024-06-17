package nicolas.library.controllers.admin;

import jakarta.validation.Valid;
import nicolas.library.controllers.services.GoogleService;
import nicolas.library.model.*;
import nicolas.library.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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

    @Autowired
    private GoogleService googleService;

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
                               @RequestParam(required = false) MultipartFile image,
                               Book book,
                               BindingResult result) throws IOException {

        Optional<Book> optionalBook = booksRepository.findById(id);
        if (!optionalBook.isPresent()) {
            logger.warn("Book with id " + id + " not found");
            return "redirect:/bookDetails/" + id;
        }

        Book existingBook = optionalBook.get();

        if (result.hasErrors()) {
            return "admin/bookedit";
        }

        if (image != null && !image.isEmpty()) {
            existingBook.setImageUrl(uploadImageForEdit(image, "images/book", existingBook.getImageUrl()));
        }


        booksRepository.save(existingBook);


        return "redirect:/BookDetails/" + id;
    }

    private String uploadImageForEdit(MultipartFile multipartFile, String folderName, String existingImageUrl) throws IOException {
        if (multipartFile.isEmpty()) return existingImageUrl;
        final String filename = multipartFile.getOriginalFilename();
        InputStream inputStream = multipartFile.getInputStream();
        return googleService.toFirebase(inputStream, folderName, filename);
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
    public String NewBookPost(Book book, BindingResult result, Model model,
                              @RequestParam String author_name,
                              @RequestParam String author_surname,
                              @RequestParam String author_country,
                              @RequestParam(required = false) MultipartFile image) throws IOException {
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

        if (image != null && !image.isEmpty()) {
            book.setImageUrl(uploadImage(image, "images/book"));
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

    private String uploadImage(MultipartFile multipartFile, String folderName) throws IOException {
        if (multipartFile.isEmpty()) return null;
        final String filename = multipartFile.getOriginalFilename();
        InputStream inputStream = multipartFile.getInputStream();
        return googleService.toFirebase(inputStream, folderName, filename);
    }

}
