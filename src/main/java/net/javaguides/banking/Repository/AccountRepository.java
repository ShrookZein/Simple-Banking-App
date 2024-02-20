package net.javaguides.banking.Repository;

import jakarta.persistence.Id;
import net.javaguides.banking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
