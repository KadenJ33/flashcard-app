<template>
  <div>
    <h1>Deck Name</h1>
    <form v-on:submit.prevent>
      <label for="answer">Name</label>
      <input type="text" id="answer" v-model="deck.name"/>
      <label for="description">Description</label>
      <input type="text" id="name" v-model="deck.description"/>
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
                userID: this.$store.state.user.id,
                name: "",
                description: ""
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