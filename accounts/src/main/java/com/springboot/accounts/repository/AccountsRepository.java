package com.springboot.accounts.repository;

import com.springboot.accounts.entity.Accounts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    Optional<Accounts> findByCustomerId(Long customerId);

    @Transactional
//    execute the query as a transaction
    @Modifying
//    indicates the query makes changes to the db
    void deleteByCustomerId(Long customerId);
}
