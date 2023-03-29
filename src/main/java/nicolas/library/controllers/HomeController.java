package nicolas.library.controllers;

import nicolas.library.model.Transactions;
import nicolas.library.repositories.BooksRepository;
import nicolas.library.repositories.GenreRepository;
import nicolas.library.repositories.TransactionRepository;
import nicolas.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class HomeController {
    @Autowired
    private BooksRepository booksRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository usersRepository;

    @Autowired
    private GenreRepository genreRepository;


    @GetMapping({ "/","/homepage"})
    public String home(Model model) {
        long booksCount = booksRepository.count();
        long usersCount = usersRepository.count();
        long genreCount = genreRepository.count();
        List<Transactions> transaction = transactionRepository.findAll();
        model.addAttribute("transactions", transaction);
        model.addAttribute("booksCount", booksCount);
        model.addAttribute("usersCount", usersCount);
        model.addAttribute("genreCount", genreCount);
        return "homepage";
    }
}
