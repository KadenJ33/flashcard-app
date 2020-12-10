package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Card;
import com.techelevator.model.Deck;

public interface cardDAO {
	
	void createCard(int deckID, int userID, String question, String answer);
	
	List<Deck> findAllCards(int userID);
	
	String addQuestion(String question);
	
	String addAnswer(String answer);
	
	Card updateCorrectness(int cardID);
	
	boolean showCorrect(int userID, int deckID);
	
	boolean showFalse(int userID, int deckID);
	
	String updateQuestion(String question);
	
	String updateAnswer(String answer);
	
	void deleteCard(int userID, int deckID);
	

}
