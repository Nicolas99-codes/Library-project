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
            "(:Genre IS NULL OR :Genre = '' OR b.genre = :Genre) AND " +
            "(:Status IS NULL OR :Status = '' OR b.status = :Status)")
    List<Book> findByFilter(@Param("Genre") String genre,
                            @Param("Status") String status);

    @Query("SELECT b FROM Book b order by b.title asc")
    List<Book> findAllOrderByTitle();
}