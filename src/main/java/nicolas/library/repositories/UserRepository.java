package nicolas.library.repositories;

import nicolas.library.model.WebUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<WebUser, Integer> {
    List<WebUser> findAll();

    long count();

    Optional<WebUser> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<WebUser> findFirstByOrderByIdDesc();

    // Book next ID

    Optional<WebUser> findFirstByIdGreaterThanOrderByIdAsc(Integer id);

    Optional<WebUser> findFirstByOrderByIdAsc();

}
