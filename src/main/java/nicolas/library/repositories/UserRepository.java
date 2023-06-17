package nicolas.library.repositories;

import nicolas.library.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll();

    long count();

    Optional<User> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<User> findFirstByOrderByIdDesc();

    // Book next ID

    Optional<User> findFirstByIdGreaterThanOrderByIdAsc(Integer id);

    Optional<User> findFirstByOrderByIdAsc();

}
