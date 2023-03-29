package nicolas.library.repositories;

import nicolas.library.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BooksRepository extends CrudRepository<Book, Integer> {
    List<Book> findAll();

    long count();

    @Query("SELECT b FROM Book b WHERE b.category = :category")
    List<Book> findByCategory(String category);

    // Book previous ID

    Optional<Book> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<Book> findFirstByOrderByIdDesc();

    // Book next ID

    Optional<Book> findFirstByIdGreaterThanOrderByIdAsc(Integer id);

    Optional<Book> findFirstByOrderByIdAsc();

    @Query("SELECT b FROM Book b WHERE " +
            "(:keyword IS NULL OR :keyword = '' OR " +
            "b.author LIKE %:keyword% OR " +
            "b.genre LIKE %:keyword% OR " +
            "b.title LIKE %:keyword% OR " +
            "b.release_year LIKE %:keyword% OR " +
            "b.status LIKE %:keyword%)")
    List<Book> findByFilter(@Param("keyword") String keyword);


    @Query("SELECT b FROM Book b order by b.title asc")
    List<Book> findAllOrderByTitle();

}