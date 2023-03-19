package nicolas.library.controllers;

import nicolas.library.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private BooksRepository booksRepository;
    @GetMapping({ "/homepage"})
    public String home(Model model) {
        long booksCount = booksRepository.count();
        model.addAttribute("booksCount", booksCount);
        return "homepage";
    }
}
