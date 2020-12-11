<template>
  <div>
    <h1>Add a name and description!</h1>
    <form v-on:submit.prevent>
      <label for="name">Name</label>
      <input v-model="deck.name" type="text" id="name"/>
      <label for="description">Description</label>
      <input v-model="deck.description" type="text" id="description"/>
      <button type="submit" @click="newDeck()">Create Deck</button>
    </form>
  </div>
</template>
<script>
import authService from '../services/AuthService';
export default {
    data(){
        return{
            deck: {
                userID: '1',
                name: '',
                description: ''
        }
    };
    },
    methods: {
        newDeck(){
            authService
            .addDeck(this.deck)
            .then(response => {
                console.log("HERE")
                if (response.status == 201) {
                    this.$router.push("/")
                }
            })
            .catch(error => {
                console.error(error);
            });
        }
    }
};
</script>
<style>
</style>