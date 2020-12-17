package com.techelevator.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.cardDAO;
import com.techelevator.model.Card;
import com.techelevator.model.cardDTO;


@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class cardController {
	
    private cardDAO myCardDAO;
    
    public cardController(cardDAO cardDAO) {
        this.myCardDAO = cardDAO;
    }
	
    
	
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/create-card", method = RequestMethod.POST)
    public void makeNewCard(@Valid @RequestBody cardDTO newCard) {
    	myCardDAO.createCard(newCard.getDeckID(), newCard.getUserID(), newCard.getQuestion(), newCard.getAnswer());
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/deck-with-cards/{deckID}", method = RequestMethod.GET)
    public List<Card> viewAllCards(@Valid @PathVariable("deckID") int deckID) {
    	return myCardDAO.findAllCards(deckID);
    }
    
    @RequestMapping(path = "/update-card/{cardID}", method = RequestMethod.PUT)
    public void updateCard(@Valid @PathVariable("cardID") int cardID, @RequestBody cardDTO card) {
    	myCardDAO.updateCard(cardID, card.getQuestion(), card.getAnswer(), card.isCorrect());
    }

    @RequestMapping(path = "/mark-correct/{cardID}", method = RequestMethod.PUT)
    public void updateCard(@Valid @PathVariable("cardID") int cardID) {
    	myCardDAO.markCardCorrect(cardID);
    }
   
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/card/{cardID}", method = RequestMethod.DELETE)
    public void deleteCard(@Valid @PathVariable("cardID") int cardID) {
    	myCardDAO.deleteCard(cardID);
    }

}
