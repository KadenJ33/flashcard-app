<template>
  <div>
    <!-- <div class="session" @click=flipCard> -->
  <h1>SESSION COMPONENT</h1>

<!-- TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST  -->

<!-- <div class="checked">Score: {{ score }} </div> -->
<!-- <div v-if="this.$store.state.cards[0].answer">
  <button @click="correct">Correct</button> -->
<!-- </div> -->




<!-- TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST  -->

  <!-- <div class="container">

      <p v-on:click="toggleCard(card)" v-for="(card) in this.$store.state.cards">
        <transition name="flip">
          <p v-bind:key="card.flipped" class="card">
              {{ card.flipped ? card.back : card.front }}
              <span v-on:click="cards.splice(index, 1)" class="delete-card">X</span>
          </p>
        </transition>
      </p>

  </div> -->


  <div class="container">

      <p v-on:click="toggleCard($store.state.cards[currentCardIndex])">
        <transition name="flip">
          <p  class="card">
              {{ this.$store.state.cards[currentCardIndex].flipped ? this.$store.state.cards[currentCardIndex].answer : this.$store.state.cards[currentCardIndex].question }}
          </p>
        </transition>
      </p>
  </div>


<button type="button" class="delete-icon" v-on:click="getNextCard()">NEXT CARD</button>
<br/>
<button v-on:click="markCorrect()">Mark Correct</button>
<br/>
<button v-on:click="endSession()">End Session</button>
<br/>
<button type="button" class="viewResults" @click="$router.push('/view-results')">View Results</button>
    </div>
  <!-- </div> -->
</template>

<script>
import authService from '../services/AuthService';
export default ({

  data(){
  return {  
      currentCardIndex: 0,
      isCorrect: false,
      correctNumber: 0
  };
  },

  methods: {
        changeCardIndex() {
          if (this.currentCardIndex + 1 <= this.$store.state.cards.length - 1) {
            this.currentCardIndex += 1
          } else {
            this.endSession()
          }
    },
      toggleCard(card) {
      card.flipped = !card.flipped;
    },
    markCorrect() {
      this.isCorrect = true
    },
    getNextCard() {
      if (this.isCorrect == true) {
          this.update(this.$store.state.cards[this.currentCardIndex].cardID)
          this.correctNumber += 1
      }
      this.$store.commit("SET_NUMBER_OF_CORRECT", this.correctNumber);
      this.changeCardIndex()
      this.isCorrect = false
    },
    endSession() {
      this.$router.push('/view-results')
    },
    update(id) {
            authService
            .markCardCorrect(id)
            .then(response => {
            })
             .catch(error => {
                console.error(error);
            });
        },
  },
  computed: {

  }
});




</script>

<style>
body {
    font-family: 'Montserrat', sans-serif;
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
  
  .correct {
    position: absolute;
    right: 0;
    top: 0;
    padding: 10px 15px;
    opacity: .4;
    transition: all 0.5s ease;
  }
  
  .correct:hover{
    opacity: 1;
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