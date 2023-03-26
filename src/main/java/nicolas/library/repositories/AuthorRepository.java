package nicolas.library.repositories;

import nicolas.library.model.Author;
import nicolas.library.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
    List<Author> findAll();

    Optional<Author> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<Author> findFirstByOrderByIdDesc();

    // Book next ID

    Optional<Author> findFirstByIdGreaterThanOrderByIdAsc(Integer id);

    Optional<Author> findFirstByOrderByIdAsc();

    @Query("SELECT a FROM Author a order by a.author_name asc")
    List<Author> findAllOrderByName();

}
