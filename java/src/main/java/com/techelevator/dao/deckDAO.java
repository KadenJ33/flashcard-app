package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Deck;

public interface deckDAO {
	
	List<Deck> findAllDecks(int userID);
	
	Deck createDeck(int userID);
	
	Deck updateName(int deckID);
	
	Deck updateCorrectness(int deckID);
	
	boolean showCorrect(int userID, int deckID);
	
	boolean showFalse(int userID, int deckID);
	
	void deleteDeck(int userID, int deckID);
	
	

}
