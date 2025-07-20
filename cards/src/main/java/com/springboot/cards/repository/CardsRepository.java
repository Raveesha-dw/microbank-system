package com.springboot.cards.repository;

import com.springboot.cards.entity.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Long> {
    Optional<Cards> findByCardNumber(String cardNumber);

    Optional<Cards> findByMobileNumber(String mobileNumber);
}
