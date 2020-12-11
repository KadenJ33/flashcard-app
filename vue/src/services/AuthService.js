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

  getDeck() {
    return axios.get('/deck-list');
  },

  deleteDeck(deckID) {
    return axios.delete(`/deck-list/${deckID}`);
  },

  getCards(deckID) {
    return axios.get(`/deck-list/${deckID}`)
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
