package nicolas.library.repositories;

import nicolas.library.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<Users, Integer> {
    List<Users> findAll();

    List<Users> findByUsername(String username);
}
