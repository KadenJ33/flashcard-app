import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  },

  addDeck(deck) {
    return axios.post('/create-deck', deck);
  },

  getDeck(userID) {
    return axios.get(`/view-decks/${userID}`);
  },

  deleteDeck(deckID) {
    return axios.delete(`/view-decks/${deckID}`);
  },

  getCards(deckID) {
    return axios.get(`/view-decks/${deckID}`)
  },

  getCard(cardID) {
    return axios.get(`/cards/${cardID}`)
  },

  addCard(card) {
    return axios.post('/cards', card);
  },

  updateCard(card) {
    return axios.put(`/cards/${card.id}`, card);
  },

  deleteCard(cardID) {
    return axios.delete(`/cards/${cardID}`);
  }

}
