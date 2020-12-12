<template>
  <div>
      <h1>Create a card!</h1>  
      <form v-on:submit.prevent> 
       <label for="question">Add a front!(question, prompt, word, etc...)</label>
       <input type="text" id="question"/>
       <label for="answer">Add a back!(answer, response, definition, etc...)</label>
       <input type="text" id="answer"/>
       <button type="submit" @click="newCard()">Create Card</button>
      </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';
export default {
    name: 'add-card',
    data(){
        return{
            card: {
                userID: this.$store.state.user.id,
                deckID: this.$store.state.decks.deckID,
                question: "",
                answer: ""
        }
    };
    },
    methods: {
        newCard() {
            authService
            .addCard(this.card)
            .then(response => {
                if (response.status == 201) {
                    this.$router.push("/deck-with-cards")
                }
            })
             .catch(error => {
                console.error(error);
            });
        }
    }




}
</script>

<style>

</style>