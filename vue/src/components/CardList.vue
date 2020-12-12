<template>
  <div>
      <h1>Your card list</h1>
      <button class="createCard" @click="$router.push('/create-card')">Add Card</button>
  
        <div class="cards"
            v-for="card in this.$store.state.cards"
        v-bind:key="card.userID">

        {{ card.question }}
        {{ card.answer }
        

       <button type="button" class="delete-icon" @click="removeCards(cardID)"/>
        </div>
  </div>
</template>

<script>
import authService from '../services/AuthService';
export default {
 data(){
    return {
    card: {
      question:'',
      answer: '',
      backgroundColor: this.randomBackgroundColor()
    }
    }
  },
  created() {
    this.retrieveCards();
  },
  name: "card-list",
  methods: {
    retrieveCards() {
      authService.getCard(this.$store.state.cards.cardID).then(response => {
        this.$store.commit("SET_CARDS", response.data);
      });
    },
    removeCards(cardID) {
      authService.deleteCard(cardID).then(response => {
        if (response.status === 200) {
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