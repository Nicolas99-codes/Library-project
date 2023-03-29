package nicolas.library.repositories;

import nicolas.library.model.Book;
import nicolas.library.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Integer>{
    List<Category> findAll();

    @Query("SELECT COUNT(b) FROM Book b WHERE b.category = :category")
    long countBooksByCategory(@Param("category") String category);

    Optional<Category> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<Category> findFirstByOrderByIdDesc();

    // Book next ID

    Optional<Category> findFirstByIdGreaterThanOrderByIdAsc(Integer id);

    Optional<Category> findFirstByOrderByIdAsc();

}
