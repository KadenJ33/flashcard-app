<template>
<<<<<<< HEAD
  <div class="container">
    <div class="wrapper">
      <div
        class="clip-text clip-text_thirteen clip-text--cover"
        v-for="deck in this.$store.state.decks"
        v-bind:key="deck.userID"
      >
        {{ deck.name }}
      </div>
    </div>
    <div class="searchBar">
      <search></search>
    </div>
    <button
      type="button"
      class="createCard"
      @click="$router.push('/create-card')"
    >
      Add a Card
    </button>
    <button
      type="button"
      class="viewSession"
      @click="$router.push('/view-session')"
    >
      Start Session
    </button>

    <div
      class="cards"
      v-for="card in this.$store.state.cards"
      v-bind:key="card.cardID"
    >
      {{ card.cardID }}
      {{ card.question }}
      {{ card.answer }}
      {{ card.rank }}
      <button type="button" @click="removeCards(card.cardID)">DELETE</button>
    </div>
=======
  <div>
    
     <h2> {{ $store.state.decks[findIndex].name }} </h2>
      <h3> {{ $store.state.decks[findIndex].description }} </h3>
     
      <h1>Your card list</h1>
      
      <button type="button" class="createCard" @click="$router.push('/create-card')">Add Card</button>
      <button type="button" class="viewSession" @click="$router.push('/view-session')">Start Session</button>
      <!-- <td><input type="text" id="questionFilter" v-model="filter.question"/></td>
       <tr v-for="card in filteredList" v-bind:key="card.cardID" > -->
        <div class="cards"
        v-for="card in this.$store.state.cards" 
        v-bind:key="card.cardID">
        {{ card.cardID }}
        {{ card.question }}
        {{ card.answer }}
        {{ card.rank }}
        <button type="button" class="updateCard" @click="$router.push({name: 'update-card', params:{cardID: card.cardID}})">EDIT</button>
        <button type="button" @click="removeCards(card.cardID)">DELETE</button>
        <!-- </tr> -->
        </div>
>>>>>>> a28dda07cd7de3a29a16d6f06bd2250e9d797a8e
  </div>
</template>

<script>
<<<<<<< HEAD
import authService from "../services/AuthService";
import Search from "../components/Search.vue";
=======
import authService from '../services/AuthService';
// import Search from '../components/Search.vue'
>>>>>>> a28dda07cd7de3a29a16d6f06bd2250e9d797a8e
export default {
  components: {
    search: Search,
  },
  data() {
    return {
<<<<<<< HEAD
      card: {
        deckID: this.$store.state.currentDeckID,
        question: "",
        answer: "",
        rank: 0,
      },
    };
  },
  created() {
    this.retrieveCards();
    this.getDeckID();
  },

=======
      // filter: {
      //   question: '',
      //   answer: ''
      // },
        card: {
            deckID: this.$store.state.currentDeckID,
            
            question: '',
            answer: '',
            rank: 0
            
        },
    }  
  }, 
   created(){
        this.retrieveCards();
        this.getDeckID();
   },
  //  components: {
  //    Search
  //  },
   computed: {
    //  filteredList() {
    //   let filteredCards = this.$store.state.cards;
    //   if( this.filter.question != "" ) {
    //     filteredCards = filteredCards.filter(card => card.question.toLowerCase().includes(this.filter.question.toLowerCase()))
    //   } 
    //   if( this.filter.answer != "" ) {
    //     filteredCards = filteredCards.filter(card => card.answer.toLowerCase().includes(this.filter.answer.toLowerCase()))
    //   }
    //   return filteredCards;
    // },
      findIndex() {
      let ID = ''
      this.$store.state.decks.forEach(deck => {
       if(deck.deckID == this.$store.state.currentDeckID) {
            ID = this.$store.state.decks.indexOf(deck)
        }
      });
      return ID;
    },
   },
>>>>>>> a28dda07cd7de3a29a16d6f06bd2250e9d797a8e
  name: "card-list",
  methods: {
    
    getDeckID() {
      this.$store.commit("SET_ID", this.$route.params.deckID);
    },
    retrieveCards() {
      authService.getCards(this.$route.params.deckID).then((response) => {
        this.$store.commit("SET_CARDS", response.data);
      });
    },
    removeCards(cardID) {
      authService.deleteCard(cardID).then((response) => {
        if (response.status === 204) {
          // this.$store.commit("DELETE_CARDS", cardID);
          location.reload();
        }
      });
    },
    randomBackgroundColor() {
      return this.generateHexCode();
    },
    generateHexCode() {
      var bg = Math.floor(Math.random() * 16777215).toString(16);
      if (bg.length !== 6) bg = this.generateHexCode();
      return bg;
    },
  },
};
</script>

<style scoped>
.container {
  position: fixed;
  z-index: -3;

  background-image: linear-gradient(
    0deg,
    rgb(252, 220, 226) 9%,
    rgba(255, 255, 255, 1) 64%
  );
  min-height: 100%;
  min-width: 100%;

  width: 100%;
  height: auto;

  top: 0;
  left: 0;
}
.wrapper {
  text-align: center;
  padding-top: 40px;
}

.clip-text {
  font-size: 6em;
  font-weight: bold;
  line-height: 1;
  position: relative;
  display: inline-block;
  margin: 0.25em;
  padding: 0.1em 0.3em;
  text-align: center;
  color: #fff;
  -webkit-background-clip: text;

  -webkit-text-fill-color: transparent;
}

.clip-text:before,
.clip-text:after {
  position: absolute;
  content: "";
}

.clip-text:before {
  z-index: -2;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  background-image: inherit;
}

.clip-text:after {
  position: absolute;
  z-index: -1;
  top: 0.125em;
  right: 0.125em;
  bottom: 0.125em;
  left: 0.125em;
  background-color: #000;
  opacity: 0.8;
}

.clip-text--cover,
.clip-text--cover:before {
  background-size: cover;
  background-position: 50% 50%;
}

.clip-text_thirteen {
  background-image: url(https://i.ytimg.com/vi/MU3qrgR2Kkc/maxresdefault.jpg);
}

.createCard {
  font-family: "Roboto", sans-serif;
  width: 150px;

  background-color: rgba(255, 255, 255, 1);
  border-radius: 10px;
  display: block;
  margin-left: auto;
  margin-right: auto;
}

.createCard:hover {
  box-shadow: 0 14px 28px rgba(0, 0, 0, 0.25), 0 10px 10px rgba(0, 0, 0, 0.22);
}

.createCard {
  margin-top: 10px;
}

.viewSession {
  font-family: "Roboto", sans-serif;
  width: 150px;

  background-color: rgba(255, 255, 255, 1);
  border-radius: 10px;
  display: block;
  margin-left: auto;
  margin-right: auto;
}

.viewSession:hover {
  box-shadow: 0 14px 28px rgba(0, 0, 0, 0.25), 0 10px 10px rgba(0, 0, 0, 0.22);
}
</style>