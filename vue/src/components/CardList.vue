<template>
  <div>
      <h1>Your card list</h1>
      <button type="button" class="createCard" @click="$router.push('/create-card')">Add Card</button>
<<<<<<< HEAD
      <table class="table">
               <thead>
          <tr>
            <th>Card ID</th>
            <th>Question</th>
            <th>Answer</th>
            <th>Rank</th>
          </tr>
        </thead>
        <tbody>
          <tr class="cards" v-for="card in this.$store.state.cards" 
            v-bind:key="card.cardID">
            <td> {{ card.cardID }} </td>
            <td> {{ card.question }}</td>
            <td> {{ card.answer }}</td>
            <td> {{ card.rank }}</td>
            <td> <button type="button" class="delete-icon" @click="removeCards(card.cardID)">DELETE</button></td>
            <td> <button type="button" class="delete-icon" @click="updateQuestion(card.cardID)">EDIT QUESTION</button></td>
            <td> <button type="button" class="delete-icon" @click="removeCards(card.cardID)">EDIT ANSWER</button></td>
          </tr>
        </tbody>
      </table>
      <input type="text">
=======
      <button type="button" class="viewSession" @click="$router.push('/view-session')">Start Session</button>

        <div class="cards"
        v-for="card in this.$store.state.cards" 
        v-bind:key="card.cardID">
        {{ card.cardID }}
        {{ card.question }}
        {{ card.answer }}
        {{ card.rank }}
        
        
        </div>
>>>>>>> 59b43e70a817a8ba2d99bcc9cf1007c2fa810442
  </div>
</template>

<script>
import authService from '../services/AuthService';
export default {
 data(){
    return {
        card: {
            
            deckID: this.$store.state.currentDeckID,
            question: '',
            answer: '',
            rank: 0
            
        },
                updatedCard: {
            
            deckID: this.$store.state.currentDeckID,
            question: '',
            answer: '',
            rank: 0
            
        }
    }  
  }, 
   created(){
        this.retrieveCards();
        this.getDeckID();
   },
  name: "card-list",
  methods: {
    getDeckID() {
      this.$store.commit("SET_ID", this.$route.params.deckID);
    },
   
    retrieveCards() {
      authService.getCards(this.$route.params.deckID).then((response) => {
        this.$store.commit("SET_CARDS", response.data);
      });
    },
<<<<<<< HEAD
    removeCards(givenCardID) {
      authService.deleteCard(givenCardID).then(response => {
        if (response.status === 200) {
=======
    removeCards(cardID) {
      authService.deleteCard(cardID).then(response => {
        if (response.status === 204) {
>>>>>>> 59b43e70a817a8ba2d99bcc9cf1007c2fa810442
          alert("Card deleted!");
          this.$store.commit("DELETE_CARDS", givenCardID);
        }
      });
    },
        updateQuestion(givenCard) {
      authService.deleteCard(givenCard).then(response => {
        if (response.status === 200) {
          alert("Card changed!");
          this.$store.commit("DELETE_CARDS", givenCard);
        }
      });
    },
    randomBackgroundColor() { 
    return this.generateHexCode();
    },
    generateHexCode() {
      var bg = Math.floor(Math.random()*16777215).toString(16);
      if (bg.length !== 6) bg = this.generateHexCode();
      return bg;
    }
  },
  
}



</script>

<style>

</style>