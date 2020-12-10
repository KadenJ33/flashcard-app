package com.techelevator.model;

public class Deck {

	private int deckID;
	private int userId;
	private String name;
	private boolean correct;
	
	public Deck() { }
	
	public Deck(int deckID, int userId, String name, boolean correct) {
		this.deckID = deckID;
		this.userId = userId;
		this.name = name;
		this.correct = correct;
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
