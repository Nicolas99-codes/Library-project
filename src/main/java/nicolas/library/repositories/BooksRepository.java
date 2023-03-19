package nicolas.library.repositories;

import nicolas.library.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BooksRepository extends CrudRepository<Book, Integer> {
    List<Book> findAll();

    long count();

}