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
    return axios.get(`/deck-with-cards/${deckID}`)
  },

  getCard(cardID) {
    return axios.get(`/cards/${cardID}`)
  },

  addCard(card) {
    return axios.post('/create-card', card);
  },

<<<<<<< HEAD
  updateCard(card) {
    return axios.put('/update-card', card);
  },

  deleteCard(cardID) {
    return axios.delete(`/delete-card/${cardID}`);
=======
  updateCard(cardID, card) {
    return axios.put(`/update-card/${cardID}`, card);
  },

  deleteCard(cardID) {
    return axios.delete(`/card/${cardID}`);
  },
  updateDeck(deckID, deck) {
    return axios.put(`/update-deck/${deckID}`, deck);
>>>>>>> a28dda07cd7de3a29a16d6f06bd2250e9d797a8e
  }

}
