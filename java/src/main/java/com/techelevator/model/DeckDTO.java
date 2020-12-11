package com.techelevator.model;

import javax.validation.constraints.NotEmpty;

public class DeckDTO {

	//instance variables
	//@NotEmpty
	private int deckID;
	private int userID;
	private String name;
	private boolean correct;
	private String description;
	private int rank;
	
	
	//constructors
	public DeckDTO() { }
	

	public DeckDTO( int deckID, int userID, String name, boolean correct, String description, int rank) {

		this.deckID = deckID;
		this.userID = userID;
		this.name = name;
		this.correct = correct;
		this.description = description;
		this.rank = rank;
	}

	//getters and setters
	public int getRank() {
		return rank;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getDeckID() {
		return deckID;
	}

	public void setDeckID(int deckID) {
		this.deckID = deckID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userId) {
		this.userID = userId;
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