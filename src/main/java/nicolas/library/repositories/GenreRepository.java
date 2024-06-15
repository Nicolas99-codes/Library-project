package nicolas.library.repositories;

import nicolas.library.model.Genre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GenreRepository extends CrudRepository<Genre, Integer>{
    List<Genre> findAll();

}
