package nicolas.library.repositories;

import nicolas.library.model.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StatusRepository extends CrudRepository<Status, Integer> {
    List<Status> findAll();
}
