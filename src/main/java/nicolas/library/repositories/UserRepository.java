package nicolas.library.repositories;

import nicolas.library.model.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<AppUser, Integer> {
    List<AppUser> findAll();

    Optional<AppUser> findByUsername(String username);

    Optional<AppUser> findById(Integer id);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}
