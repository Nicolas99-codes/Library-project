package nicolas.library.controllers.admin;

import nicolas.library.model.Book;
import nicolas.library.repositories.BooksRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class BookAdminController {

    private final Logger logger = LoggerFactory.getLogger(BookAdminController.class);
    @Autowired
    private BooksRepository booksRepository;

    @ModelAttribute("book")
    public Book findBook(@PathVariable(required = false) Integer id){
        logger.info("findBook" + id);
        if (id == null) return new Book();

        Optional<Book> optionalBook = booksRepository.findById(id);
        if (optionalBook.isPresent())
            return optionalBook.get();
        return null;
    }

    @GetMapping("/bookedit/{id}")
    public String BookEdit(Model model, @PathVariable int id){
        logger.info("BookEdit" + id);
        model.addAttribute("books", booksRepository.findAll());
        return "admin/bookedit";
    }

    @PostMapping("/bookedit/{id}")
    public String BookEditPost(@PathVariable int id,
                               Book book){
        logger.info("BookEditPost " + id + " -- new book= " + book.getTitle() + ", new author = " + book.getAuthor() + ", new genre = " + book.getGenre() + ", new year = " + book.getRelease_year() + ", new description = " + book.getDescription());
        booksRepository.save(book);
        return "redirect:/BookDetails/" + id;
    }

    @GetMapping("/newbook")
    public String NewBook(Model model){
        logger.info("NewBook");
        model.addAttribute("books", booksRepository.findAll());
        return "admin/newbook";
    }

    @PostMapping("/newbook")
    public String NewBookPost(Model model, Book book){
        logger.info("NewBookPost -- new book = " + book.getTitle() + ", new author = " + book.getAuthor() + ", new genre = " + book.getGenre() + ", new year = " + book.getRelease_year() + ", new description = " + book.getDescription());
        Book newBook = booksRepository.save(book);
        return "redirect:/BookDetails/" + newBook.getId();
    }
}
