package com.techelevator.model;

import javax.validation.constraints.NotEmpty;

public class DeckDTO {

	//instance variables
	//@NotEmpty
	private int deckID;
	private int userId;
	private String name;
	private boolean correct;
	private String description;
	private int rank;
	
	
	//constructors
	public DeckDTO() { }
	
<<<<<<< HEAD:java/src/main/java/com/techelevator/model/DeckDTO.java
	public DeckDTO( int deckId, int userId, String name, boolean correct) {
=======
	public NewDeckDTO( int deckId, int userId, String name, boolean correct, String description, int rank) {
>>>>>>> b52959af26a26bfb29a558897fc46505d3ee3e3f:java/src/main/java/com/techelevator/model/NewDeckDTO.java
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