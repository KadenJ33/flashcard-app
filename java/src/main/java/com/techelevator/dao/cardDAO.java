package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Card;
import com.techelevator.model.Deck;

public interface cardDAO {
	
	void createCard(int deckID, int userID, String question, String answer);
	
	List<Card> findAllCards(int userID);
	
	void updateCard(int userID, int deckID, int cardID, String question, String answer, Boolean correct);
	
	void deleteCard(int userID, int deckID, int cardID);
	
	
	//probably deleting
	void updateCorrectTrue(int cardID);
	
	void updateCorrectFalse(int cardID);
	
	List<Card> showTrueAndFalse(int userID, int deckID);
	
	List<Card> showTrue(int userID, int deckID);
	
	List<Card> showFalse(int userID, int deckID);
	
	void updateQuestion(String question, int cardID);
	
	void updateAnswer(String answer, int cardID);
	
	
	

}
