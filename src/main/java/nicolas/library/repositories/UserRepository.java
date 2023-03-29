package nicolas.library.repositories;

import nicolas.library.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<Users, Integer> {
    List<Users> findAll();

    long count();

    Optional<Users> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<Users> findFirstByOrderByIdDesc();

    // Book next ID

    Optional<Users> findFirstByIdGreaterThanOrderByIdAsc(Integer id);

    Optional<Users> findFirstByOrderByIdAsc();

}
