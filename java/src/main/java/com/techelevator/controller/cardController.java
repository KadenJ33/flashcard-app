package com.techelevator.controller;

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
import com.techelevator.model.NewDeckDTO;
import com.techelevator.model.cardDTO;



@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class cardController {
	
    private cardDAO mycardDAO;
    
    public cardController(cardDAO cardDAO) {
        this.mycardDAO = cardDAO;
    }
	
    
	
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/create-card", method = RequestMethod.POST)
    public void makeNewCard(@Valid @RequestBody cardDTO newCard) {
    	
    	mycardDAO.createCard(newCard.getDeckID(), newCard.getUserID(), newCard.getQuestion(), newCard.getAnswer());
    }
    
    
    
}
