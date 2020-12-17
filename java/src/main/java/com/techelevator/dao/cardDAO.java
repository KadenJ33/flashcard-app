package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Card;
import com.techelevator.model.Deck;

public interface cardDAO {
	
	void createCard(int deckID, int userID, String question, String answer);
	
	List<Card> findAllCards(int userID);
	
	void updateCard(int cardID, String question, String answer, boolean correct);
	
	void markCardCorrect(int cardID);
	
	void deleteCard(int cardID);

}
