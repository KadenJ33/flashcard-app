<template>
  <div>
    <h1>Deck Name</h1>
    <form>
      <label for="answer">Name</label>
      <input type="text" id="answer"/>
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
                name: 'HELPME',
        }
    };
    },
    methods: {
        newDeck(){
            authService
            .addDeck(this.deck)
            // .then(response => {
            //     console.log("HERE")
            //     if (response.status == 201) {
            //         this.$router.push("/")
            //     }
            // })
            // .catch(error => {
            //     console.error(error);
            // });
        }
    }

};
</script>

<style>
</style>