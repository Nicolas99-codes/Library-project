package nicolas.library.repositories;

import nicolas.library.model.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
    List<Author> findAll();

    @Query("SELECT a FROM Author a order by a.author_name asc")
    List<Author> findAllOrderByName();

}
