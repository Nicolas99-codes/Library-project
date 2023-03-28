package nicolas.library.repositories;

import nicolas.library.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Integer>{
    List<Category> findAll();

    @Query("SELECT COUNT(b) FROM Book b WHERE b.category = :category")
    long countBooksByCategory(@Param("category") String category);


}
