package nicolas.library.controllers;

import nicolas.library.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/BookCategories")
    public String showBookCategory(Model model){
        long mangaCount = categoryRepository.countBooksByCategory("Manga");
        long lightNovelCount = categoryRepository.countBooksByCategory("Light Novel");
        long manhwaCount = categoryRepository.countBooksByCategory("Manhwa");

        model.addAttribute("mangaCount", mangaCount);
        model.addAttribute("lightNovelCount", lightNovelCount);
        model.addAttribute("manhwaCount", manhwaCount);
        return "BookCategories";
    }


}
