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
    List<Book> findByCategory(@Param("category") String category);

    @Query("SELECT b FROM Book b WHERE b.price = :price")
    List<Book> findByPrice(@Param("price") String price);

    @Query("SELECT b FROM Book b WHERE b.status = :status")
    List<Book> findByStatus(@Param("status") String status);

    @Query("SELECT b FROM Book b WHERE b.genre = :genre")
    List<Book> findByGenre(@Param("genre") String genre);

    @Query("SELECT b FROM Book b WHERE b.release_year = :year")
    List<Book> findByReleaseYear(@Param("year") Integer year);

    @Query("SELECT b FROM Book b WHERE b.title = :name")
    List<Book> findByTitle(@Param("name") String name);

    Optional<Book> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<Book> findFirstByOrderByIdDesc();

    Optional<Book> findFirstByIdGreaterThanOrderByIdAsc(Integer id);

    Optional<Book> findFirstByOrderByIdAsc();

    @Query("SELECT b FROM Book b ORDER BY b.title ASC")
    List<Book> findAllOrderByTitle();
}
