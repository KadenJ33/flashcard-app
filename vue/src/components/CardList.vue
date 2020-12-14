<template>
  <div>
    <div v-for="deck in this.$store.state.decks" v-bind:key="deck.userID">
      <!-- <div v-if="deck.deckID === currentDeckID">  -->
      {{ deck.name }}
      {{ deck.description }}
      </div>
      <!-- </div> -->
      <h1>Your card list</h1>
      <button type="button" class="createCard" @click="$router.push('/create-card')">Add Card</button>
      <button type="button" class="viewSession" @click="$router.push('/view-session')">Start Session</button>
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
    removeCards(givenCardID) {
      authService.deleteCard(givenCardID).then(response => {
        if (response.status === 204) {
          alert("Card deleted!");
          this.$store.commit("DELETE_CARDS", givenCardID);
          location.reload();
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