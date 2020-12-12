<template>
  <div>
    <h1>Your Deck List</h1>
    <button class="createDeck" @click="$router.push('create-deck')">Add Deck</button>
    
    <div class="decks" 
        
        v-for="deck in this.$store.state.decks"
        v-bind:key="deck.userID">

        {{ deck.name }}
        {{ deck.description }}

      <button type="button" class="delete-icon" @click="removeDecks(deckID)"/>
    </div>
    <h2>View Deck</h2>
    
    <button id="view-deck" type="submit" @click="veiwDeck()"> </button>
  
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  data(){
    return {
    deck: {
      name:'',
      description: '',
      backgroundColor: this.randomBackgroundColor()
    }
    }
  },
  created() {
    this.retrieveDecks();
  },
  name: "deck-list",
  methods: {
    viewDeck() {
            this.$router.push("/deck-with-cards")
        },
    retrieveDecks() {
      authService.getDeck(this.$store.state.user.id).then(response => {
        this.$store.commit("SET_DECKS", response.data);
      });
    },
    removeDecks(deckID) {
      authService.deleteDeck(deckID).then(response => {
        if (response.status === 200) {
          alert("Deck deleted!");
          this.$store.commit("DELETE_DECKS", deckID);
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