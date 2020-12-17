package com.techelevator.model;

public class Card {

	private int cardID;
	private int deckID;
	private int userID;
	private String question;
	private String answer;
	private boolean correct;
	private int rank;
	
	public Card() { }
	
	public Card(int cardID, int deckID, int userID, String question, String answer, boolean correct, int rank) {
		this.cardID = cardID;
		this.deckID = deckID;
		this.userID = userID;
		this.question = question;
		this.answer = answer;
		this.correct = correct;
		this.rank = rank;
	}

	//getters and setters
	public int getRank() {
		return rank;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public int getCardID() {
		return cardID;
	}
	
	public void setCardID(int cardID) {
		this.cardID = cardID;
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
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public boolean isCorrect() {
		return correct;
	}
	
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

}
