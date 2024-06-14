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
    private BooksRepository booksRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/categoryPage")
    public String showBookCategory(Model model){
        Iterable<Category> categories = categoryRepository.findAll();

        for (Category category : categories ) {
            List<Book> BooksInCategory = booksRepository.findByCategory(category);
            category.setBooks(BooksInCategory);
        }

        model.addAttribute("categories", categories);

        return "BookCategories";
    }

    @GetMapping("/selectedCategoryPage/{id}")
    public String selectedCategoryPage(@PathVariable(required = false) Integer id, Model model){
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()){
            List<Book> BooksInCategory = booksRepository.findByCategory(category.get());
            category.get().setBooks(BooksInCategory);
            model.addAttribute("category", category.get());
        }
        return "selectedCategoryPage";
    }

}
