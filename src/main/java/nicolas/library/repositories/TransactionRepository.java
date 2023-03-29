package nicolas.library.repositories;

import nicolas.library.model.Transactions;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transactions, Integer> {

    List<Transactions> findAll();
}
