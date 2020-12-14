<template>
  <div>
      <h1>Your card list</h1>
      <button type="button" class="createCard" @click="$router.push('/create-card')">Add Card</button>
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
          </tr>
        </tbody>
      </table>
  </div>
</template>

<script>
import authService from '../services/AuthService';
export default {
 data(){
    return {
        card: {
            
            deckID: 0,
            question: '',
            answer: '',
            
        },
    }  
  }, 
   created(){
        this.retrieveCards();
   },
  name: "card-list",
  methods: {
   
    retrieveCards() {
      authService.getCards(this.$route.params.deckID).then((response) => {
        this.$store.commit("SET_CARDS", response.data);
      });
    },
    removeCards(givenCardID) {
      authService.deleteCard(givenCardID).then(response => {
        if (response.status === 200) {
          alert("Card deleted!");
          this.$store.commit("DELETE_CARDS", givenCardID);
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