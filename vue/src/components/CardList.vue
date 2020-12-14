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

        <div class="cards"
        v-for="card in this.$store.state.cards" 
        v-bind:key="card.cardID">
        {{ card.cardID }}
        {{ card.question }}
        {{ card.answer }}
        {{ card.rank }}
        
        
        </div>
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
    removeCards(cardID) {
      authService.deleteCard(cardID).then(response => {
        if (response.status === 204) {
          alert("Card deleted!");
          this.$store.commit("DELETE_CARDS", cardID);
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