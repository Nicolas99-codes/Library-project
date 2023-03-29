package nicolas.library.controllers;

import nicolas.library.model.Book;
import nicolas.library.model.Category;
import nicolas.library.repositories.BooksRepository;
import nicolas.library.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class CategoryController {

    @Autowired
    private BooksRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/BookCategories")
    public String showBookCategory(Model model){
        List<Category> categories = categoryRepository.findAll();

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

        model.addAttribute("categories", categoryRepository.findAll());
        return "BookCategories";
    }

    @GetMapping({"/categorydetails/{id}"})
    public String showCategoryDetails(Model model, @PathVariable int id){
        Optional<Category> CategoryFromDb = categoryRepository.findById(id);
        if (CategoryFromDb.isPresent()){
            model.addAttribute("category", CategoryFromDb.get());
        }
        List<Book> mangaBooks = bookRepository.findByCategory("Manga");
        List<Book> lightNovelBooks = bookRepository.findByCategory("Light Novel");
        List<Book> manhwaBooks = bookRepository.findByCategory("manhwa");

        model.addAttribute("mangaBooks", mangaBooks);
        model.addAttribute("lightNovelBooks", lightNovelBooks);
        model.addAttribute("manhwaBooks", manhwaBooks);

        return "categorydetails";
    }

    @GetMapping({"/categorydetails/{id}/prev"})
    public String showCategoryDetailsPrev(Model model, @PathVariable int id) {
        Optional<Category> prevCategoryFromDb = categoryRepository.findFirstByIdLessThanOrderByIdDesc(id);
        if (prevCategoryFromDb.isPresent()) {
            return String.format("redirect:/categorydetails/%d", prevCategoryFromDb.get().getId());
        }
        Optional<Category> lastCategoryFromDb = categoryRepository.findFirstByOrderByIdDesc();
        if (lastCategoryFromDb.isPresent())
            return String.format("redirect:/categorydetails/%d", lastCategoryFromDb.get().getId());
        model.addAttribute("prevDisabled", true);
        model.addAttribute("nextDisabled", false);
        model.addAttribute("category", categoryRepository.findById(id).get());
        return "categorydetails";
    }

    @GetMapping({"/categorydetails/{id}/next"})
    public String showCategoryDetailsNext(Model model, @PathVariable int id) {
        Optional<Category> nextCategoryFromDb = categoryRepository.findFirstByIdGreaterThanOrderByIdAsc(id);
        if (nextCategoryFromDb.isPresent())
            return String.format("redirect:/categorydetails/%d", nextCategoryFromDb.get().getId());
        Optional<Category> firstCategoryFromDb = categoryRepository.findFirstByOrderByIdAsc();
        if (firstCategoryFromDb.isPresent())
            return String.format("redirect:/categorydetails/%d", firstCategoryFromDb.get().getId());
        return "categorydetails";
    }

}
