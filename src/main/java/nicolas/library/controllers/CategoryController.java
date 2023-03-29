package nicolas.library.controllers;

import nicolas.library.model.Book;
import nicolas.library.repositories.BooksRepository;
import nicolas.library.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private BooksRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/BookCategories")
    public String showBookCategory(Model model){
        long mangaCount = categoryRepository.countBooksByCategory("Manga");
        long lightNovelCount = categoryRepository.countBooksByCategory("Light Novel");
        long manhwaCount = categoryRepository.countBooksByCategory("Manhwa");

        List<Book> mangaBooks = bookRepository.findByCategory("Manga");
        List<Book> lightNovelBooks = bookRepository.findByCategory("Light Novel");
        List<Book> manhwaBooks = bookRepository.findByCategory("Manhwa");

        model.addAttribute("mangaCount", mangaCount);
        model.addAttribute("lightNovelCount", lightNovelCount);
        model.addAttribute("manhwaCount", manhwaCount);
        model.addAttribute("mangaBooks", mangaBooks);
        model.addAttribute("lightNovelBooks", lightNovelBooks);
        model.addAttribute("manhwaBooks", manhwaBooks);

        return "BookCategories";
    }


}
