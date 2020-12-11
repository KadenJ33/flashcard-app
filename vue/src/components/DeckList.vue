<template>
  <div>
    <h1>Your Deck List</h1>
    <button class="createDeck" @click="$router.push('create-deck')">Add Deck</button>
  
    <div class="decks"
   
        v-for ="deck in this.$store.state.decks"
        v-bind:key ="deck.deckID">
        
        {{ deck.name }}
      
    </div>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: "deck-list",
  methods: {
    retrieveDecks() {
      authService.getDeck().then(response => {
        this.$store.commit("SET_DECK", response.data);
      });
    },
    removeDecks(deckID) {
      authService.deleteDeck(deckID).then(response => {
        if (response.status === 200) {
          this.getDeck();
        }
      });
    }
  },
  created() {
    this.retrieveDecks();
  }
}
</script>

<style>

</style>