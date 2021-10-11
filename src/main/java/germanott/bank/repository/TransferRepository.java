package germanott.bank.repository;

import germanott.bank.entity.Account;
import germanott.bank.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer,Long> {

}
