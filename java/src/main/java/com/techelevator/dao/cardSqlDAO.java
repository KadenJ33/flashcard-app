package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Card;
import com.techelevator.model.Deck;

@Component
public class cardSqlDAO implements cardDAO {
	private JdbcTemplate jdbc;
	
	public cardSqlDAO(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	
//controller done
	@Override
	public void createCard(int deckID, int userID, String question, String answer) {
		String sql = "INSERT INTO cards (card_id, deck_id, user_id, question, answer, correct, rank) VALUES (DEFAULT, ?, ?, ?, ?, DEFAULT, DEFAULT)";
		jdbc.update(sql, deckID, userID, question, answer);
	}

//controller done
	@Override
	public List<Card> findAllCards(int deckID) {
		List<Card> cards = new ArrayList<>();
		String sql = "SELECT card_id, deck_id, user_id, question, answer, correct, rank FROM cards WHERE deck_id = ?";
		SqlRowSet results = jdbc.queryForRowSet(sql, deckID);
		while(results.next()) {
			Card card = mapRowToCardWithUser(results);
			cards.add(card);
		}
		return cards;
	}
	
	@Override
	public void markCardCorrect(int cardID) {
			String updateRank = "UPDATE cards SET rank = rank + 1 WHERE card_id = ?";
			jdbc.update(updateRank, cardID);
			String deckSQL = "SELECT deck_id FROM cards WHERE card_id = ?";
			int deckID = jdbc.queryForObject(deckSQL, int.class, cardID);
			String rankPercent = "SELECT rank FROM cards WHERE deck_id = ?";
			SqlRowSet results = jdbc.queryForRowSet(rankPercent, deckID);
			int rankCount = 0;
			int numOfCard = 0;
				while(results.next()) {
					Card card = new Card();
					card.setRank(results.getInt("rank"));
					rankCount += card.getRank();
					numOfCard++;
				}
			int totalCardsRankPossible = numOfCard * 5;
			double calculatedPercentage = (double)rankCount / (double)totalCardsRankPossible;
			double tempPercent = calculatedPercentage * 100;
			int finalPercent = (int)tempPercent;
			String update = "UPDATE decks SET rank = ? WHERE deck_id = ?";
			jdbc.update(update, finalPercent, deckID);
			//changes correct status based on rank average
			String percentage = "SELECT rank FROM decks WHERE  deck_id = ?";
			int result = jdbc.queryForObject(percentage, int.class, deckID);
				if(result < 100) {
					String updateToFalse = "UPDATE decks SET correct = false WHERE deck_id = ?";
					jdbc.update(updateToFalse, deckID);
				} else {
					String updateToTrue = "UPDATE decks SET correct = true WHERE deck_id = ?";
					jdbc.update(updateToTrue, deckID);
				}
	}
	
	
	@Override
	public void updateCard(int cardID, String question, String answer, boolean correct) {
		String sql = "UPDATE cards SET question = ?, answer = ?, correct = ? WHERE card_id = ?";
		jdbc.update(sql, question, answer, correct, cardID);
		
		String checkCorrect = "SELECT correct FROM cards WHERE card_id = ?";
		boolean results = jdbc.queryForObject(checkCorrect, boolean.class, cardID);
		
		if(results == true) {
			String updateRank = "UPDATE cards SET rank = rank + 1 WHERE card_id = ?";
			jdbc.update(updateRank, cardID);
			
		} 
	}
		
	
	@Override
	public void deleteCard(int cardID) {
		String sql = "DELETE FROM cards WHERE card_id = ?";
		jdbc.update(sql, cardID);
	}

//this stays -- helper method to get data into object --
	private Card mapRowToCardWithUser(SqlRowSet rs) {
        Card card = new Card();
        card.setCardID(rs.getInt("card_id"));
        card.setUserID(rs.getInt("user_id"));
        card.setDeckID(rs.getInt("deck_id"));
        card.setQuestion(rs.getString("question"));
        card.setAnswer(rs.getString("answer"));
        card.setCorrect(rs.getBoolean("correct"));
        card.setRank(rs.getInt("rank"));
        return card;
    }

//end brace
}
