package com.springboot.cards.service.impl;

import com.springboot.cards.constants.CardsConstants;
import com.springboot.cards.dto.CardsDto;
import com.springboot.cards.entity.Cards;
import com.springboot.cards.exception.CardAlreadyExistsException;
import com.springboot.cards.exception.ResourceNotFoundException;
import com.springboot.cards.mapper.CardsMapper;
import com.springboot.cards.repository.CardsRepository;
import com.springboot.cards.service.ICardsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardsServiceImpl implements ICardsService {

    private CardsRepository cardsRepository;
    @Override
    public void createCard(String mobileNumber) {
        Optional<Cards> card = cardsRepository.findByMobileNumber(mobileNumber);
        if (card.isPresent()){
            throw new CardAlreadyExistsException("Card already registered with given mobile number " + mobileNumber);
        }

        cardsRepository.save(createNewCard(mobileNumber));
    }

    private Cards createNewCard(String mobileNumber){
        Cards newCard = new Cards();
        newCard.setMobileNumber(mobileNumber);

        long ranNum = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(ranNum));
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);

        return newCard;
    }

    @Override
    public CardsDto fetchCard(String mobileNumber) {
        Cards card = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () ->new ResourceNotFoundException("Card", "Mobile Number", mobileNumber)
        );

        return CardsMapper.mapToCardsDto(card, new CardsDto());
    }

    @Override
    public boolean updateCardDetails(CardsDto cardsDto) {
        Cards cards = cardsRepository.findByCardNumber(cardsDto.getCardNumber()).orElseThrow(
                ()-> new ResourceNotFoundException("Card", "Card Number", cardsDto.getCardNumber())
        );
        cards =  CardsMapper.mapToCards(cardsDto, cards);
        cardsRepository.save(cards);

        return true;
    }

    @Override
    public boolean deleteCard(String mobileNumber) {
        Cards card = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "Mobile Number", mobileNumber)
        );

        cardsRepository.deleteById(card.getCardId());
        return true;
    }
}
