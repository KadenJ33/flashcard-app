package com.techelevator.model;

import javax.validation.constraints.NotEmpty;

public class NewDeckDTO {

	//instance variables
	//@NotEmpty
	private int deckID;
	private int userId;
	private String name;
	private boolean correct;
	private String description;
	private int rank;
	
	
	//constructors
	public NewDeckDTO() { }
	

	public NewDeckDTO( int deckId, int userId, String name, boolean correct, String description, int rank) {

		this.deckID = deckID;
		this.userId = userId;
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