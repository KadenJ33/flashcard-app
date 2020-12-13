<template>
  <div class="container">
    <h1>Your Deck List</h1>
    <button class="createDeck" @click="$router.push('create-deck')">Add Deck</button>
    <div class="container">
      <table class="table">
        <thead>
          <tr>
            <th>Deck Name</th>
            <th>Description</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody>
          <tr class="decks" 
        
            v-for="deck in this.$store.state.decks"
            v-bind:key="deck.userID">
            <td>{{ deck.name }}</td>
            <td>{{ deck.description }}</td>
            <td>{{ deck.deckID }}
            <td>
              <button type="button" class="delete-icon" @click="removeDecks(deck.deckID)">DELETE</button>
            </td>
            <button id="view-deck" type="button" @click="$router.push({
   name: 'deck-with-cards', params: {deckID: deck.deckID }})">View Cards</button>
          </tr>
        </tbody>
      </table>
    </div>
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
      deckID: this.$route.params.deckID,
    }
    }
  },
  created() {
    this.retrieveDecks();
  },
  name: "deck-list",
  methods: {
    retrieveDecks() {
      authService.getDeck(this.$store.state.user.id).then(response => {
        this.$store.commit("SET_DECKS", response.data);
      });
    },
    removeDecks(removedDeckID) {
      authService.deleteDeck(removedDeckID).then(response => {
        if (response.status === 204) {
          alert("Deck deleted!");
          // this.$store.commit(removedDeckID);
          this.$router.push("/");
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
/* .decks {
  display: grid;
  grid-template-rows: repeat(2, 1fr);
  grid-gap: 20px;
}
.delete-icon{

} */
</style>