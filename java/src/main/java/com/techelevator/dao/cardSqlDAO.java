package com.techelevator.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.techelevator.model.Card;
import com.techelevator.model.Deck;

@Component
public class cardSqlDAO implements cardDAO {
	private JdbcTemplate jdbc;
	
	public cardSqlDAO(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	

	@Override
	public void createCard(int deckID, int userID, String question, String answer) {
		String sql = "INSERT INTO cards (card_id, deck_id, user_id, question, answer, correct) VALUES (DEFAULT, ?, ?, ?, ?, ?)";
		jdbc.update(sql, deckID, userID, question, answer, false);
	}



	@Override
	public List<Deck> findAllCards(int userID) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String addQuestion(String question) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String addAnswer(String answer) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Card updateCorrectness(int cardID) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean showCorrect(int userID, int deckID) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean showFalse(int userID, int deckID) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public String updateQuestion(String question) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String updateAnswer(String answer) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void deleteCard(int userID, int deckID) {
		// TODO Auto-generated method stub
		
	}
}
