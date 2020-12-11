package com.techelevator.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.techelevator.dao.cardDAO;
import com.techelevator.dao.deckDAO;
<<<<<<< HEAD
import com.techelevator.model.DeckDTO;
=======
import com.techelevator.model.Card;
import com.techelevator.model.NewDeckDTO;
>>>>>>> b52959af26a26bfb29a558897fc46505d3ee3e3f
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
    
    
    @RequestMapping(path = "/card-list", method = RequestMethod.GET)
    public List<Card> viewAllCards(@Valid @RequestBody cardDTO card) {
    	return myCardDAO.findAllCards(card.getUserID(), card.getDeckID());
    	
    }
    
    @RequestMapping(path = "/card/mark-right", method = RequestMethod.PUT)
    public void markRight(@Valid @RequestBody cardDTO card) {
    	myCardDAO.updateCorrectTrue(card.getCardID());
    }
    
    @RequestMapping(path = "/card/mark-wrong", method = RequestMethod.PUT)
    public void markWrong(@Valid @RequestBody cardDTO card) {
    	myCardDAO.updateCorrectFalse(card.getCardID());
    }
    
   //update question
    
    @RequestMapping(path = "/update-question", method = RequestMethod.PUT)
    public void updateQuestion(@Valid @requestBody cardDTO card) {
    	myCardDAO.updateQuestion(card.getQuestion(), card.getCardID());
    }
   //update answer
   //delete card 
    
}
