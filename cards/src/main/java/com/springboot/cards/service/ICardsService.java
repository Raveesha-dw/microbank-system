package com.springboot.cards.service;

import com.springboot.cards.dto.CardsDto;

public interface ICardsService {

    void createCard(String mobileNumber);

    CardsDto fetchCard(String mobileNumber);

    boolean updateCardDetails(CardsDto cardsDto);

    boolean deleteCard(String mobileNumber);
}
