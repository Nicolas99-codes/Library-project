package nicolas.library.repositories;

import nicolas.library.model.Book;
import nicolas.library.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface BooksRepository extends CrudRepository<Book, Integer> {
    List<Book> findAll();

    long count();

    @Query("SELECT b FROM Book b JOIN b.categories c WHERE c = :category")
    List<Book> findByCategory(@Param("category") Category category);

    @Query("SELECT DISTINCT b.release_year FROM Book b")
    List<String> findDistinctReleaseYear();

    @Query("SELECT b FROM Book b WHERE b.release_year = :releaseYear")
    List<Book> findByReleaseYear(@Param("releaseYear") String releaseYear);

    List<Book> findByTitleContainingIgnoreCaseOrderByTitle(String title);



    Optional<Book> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<Book> findFirstByOrderByIdDesc();

    Optional<Book> findFirstByIdGreaterThanOrderByIdAsc(Integer id);

    Optional<Book> findFirstByOrderByIdAsc();

    @Query("SELECT b FROM Book b ORDER BY b.title ASC")
    List<Book> findAllOrderByTitle();
}
