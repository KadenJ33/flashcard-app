package com.techelevator.model;

import javax.validation.constraints.NotEmpty;

public class DeckDTO {

	//instance variables
	//@NotEmpty
	private int deckID;
	private int userId;
	private String name;
	private boolean correct;
	
	
	//constructors
	public DeckDTO() { }
	
	public DeckDTO( int deckId, int userId, String name, boolean correct) {
		this.deckID = deckID;
		this.userId = userId;
		this.name = name;
		this.correct = correct;
	}


	//getters and setters
	public int getDeckID() {
		return deckID;
	}

	public void setDeckID(int deckID) {
		this.deckID = deckID;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	
}