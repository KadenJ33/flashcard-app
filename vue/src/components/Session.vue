<template>
  <div>
    <div class="session">
  <h1>SESSION COMPONENT</h1>




  <div class="container">

      <p v-on:click="toggleCard(this.$store.state.cards[0])" >
        <transition name="flip">
          <!-- <p v-bind:key="card.flipped" class="card"> -->
            <p class="card">
              {{ this.$store.state.cards[0].flipped ? this.$store.state.cards[0].answer : this.$store.state.cards[0].question }}
              <!-- <span v-on:click="cards.splice(index, 1)" class="delete-card">X</span> -->
          </p>
        </transition>
      </p>

  </div>







    </div>
  </div>
</template>

<script>



// const cards = [
//     {
//       front: 'FRONT',
//       back: 'BACK',
//       flipped: false,
//     },
// ]; 

export default ({
//   data: function() {
// return {
//     cards: cards,
//     newFront: '',
//     newBack: '',
//     error: false
//   };
// },
  methods: {
    toggleCard: function(card) {
      card.flipped = !card.flipped;
    },
  }
});




</script>

<style>
body {
    font-family: 'Montserrat', sans-serif;
    text-align: center;
  }
  
  p {
    align-content: center;
    list-style-type: none;
    padding: 10px 10px;
    transition: all 0.3s ease;
  }
  
  .container {
    max-width: 100%;
    padding: 5em;
  }
  
  .card {
    display: block;
    width: 650px;
    height: 350px;
    padding: 80px 50px;
    background-color: #51aae5;
    border-radius: 7px;
    margin: 5px;
    text-align: center;
    line-height: 27px;
    cursor: pointer;
    position: relative;
    color: #fff;
    font-weight: 600;
    font-size: 20px;
    -webkit-box-shadow: 9px 10px 22px -8px rgba(209,193,209,.5);
    -moz-box-shadow: 9px 10px 22px -8px rgba(209,193,209,.5);
    box-shadow: 9px 10px 22px -8px rgba(209,193,209,.5);
    will-change: transform;
  }
  
  p:hover{
    transform: scale(1.1);
  }
  
  p:nth-child(-n+3) .card{
    background-color: #e65f51;
    }
  
  p:nth-child(2n+1) .card{
    background-color: #a17de9;
    }
  
  p:nth-child(4n) .card{
    background-color: #feca34;
    }
  
  p:nth-child(5n-2) .card{
    background-color: #51aae5;
    }
  
  p:nth-child(4n+4) .card{
    background-color: #feca34;
    }
  
  p:nth-child(-7n+7) .card{
    background-color: #e46055;
    }
  
  .delete-card {
    position: absolute;
    right: 0;
    top: 0;
    padding: 10px 15px;
    opacity: .4;
    transition: all 0.5s ease;
  }
  
  .delete-card:hover{
    opacity: 1;
    transform: rotate(360deg);
  }
  
  .flip-enter-active {
    transition: all 0.4s ease;
  }
  
  .flip-leave-active {
    display: none;
  }
  
  .flip-enter, .flip-leave {
    transform: rotateY(180deg);
    opacity: 0;
  
  }
  
</style>