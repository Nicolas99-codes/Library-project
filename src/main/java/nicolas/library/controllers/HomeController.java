package nicolas.library.controllers;

import nicolas.library.model.Book;
import nicolas.library.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class HomeController {

    @Autowired
    private BooksRepository booksRepository;


    @GetMapping({ "/","/homepage"})
    public String home(Model model) {


        // Find recently added books (e.g., last 5 added)
        List<Book> recentBooks = booksRepository.findTop5ByOrderByAddedDateDesc();

        model.addAttribute("recentBooks", recentBooks);

        return "homepage";
    }
}
