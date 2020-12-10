<template>
  <div>
    <h1>Deck Name</h1>
    <form>
      <label for="answer">Name</label>
      <input v-model="deck.name" type="text" id="answer" required />
      <button type="submit">Create Deck</button>
    </form>
  </div>
</template>

<script>
import AuthService from '../services/AuthService';
export default {
    data(){
        return{
            deck: {
                userID: '1',
                name: '',
        }
    };
    },
    methods: {
        addDeck(){
            AuthService.addDeck(this.deck)
        }
    }

};
</script>

<style>
</style>