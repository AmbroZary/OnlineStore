package finances.infrastructure.Repositories.TestRepositories;


import common.Repositories.CommonTestRepository;
import finances.domain.TransactionAggregate.Repository.TransactionRepository;
import finances.domain.TransactionAggregate.Transaction;
import org.springframework.stereotype.Component;

// @Component
public class TransactionTestRepository extends CommonTestRepository<Transaction> implements TransactionRepository{
}
