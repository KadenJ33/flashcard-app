<template>
  <div>
      <h1>UPDATE</h1> 

  <form>
      <input type="text" id="question" name="question">
  </form>
  
  
  
  
  
  
  </div>
</template>

<script>
import authService from '../services/AuthService.vue'
export default {
    data() {
        return {
            card: {
                userID: this.$store.state.user.id,
                deckID: this.$store.state.currentDeckID,
            
                question: '',
                answer: '',
                rank: 0
            },

        };
    },
    methods: {
       
        editCard() {
            authService
            .updateCard(this.card)
            .then(response => {
                if (response.status == 201) {
                    this.$router.push({name: "deck-with-cards", params: {currentDeckId: this.currentDeckID}})
                }
            })
             .catch(error => {
                console.error(error);
            });
        }
    },
name: 'edit-card',
}
</script>

<style>

</style>