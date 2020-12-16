<template>
  <div class="container">
    <div class="wrapper">
      <div class="clip-text clip-text_thirteen clip-text--cover">
        {{ $store.state.decks[findIndex].name }}
        <!-- <h3>{{ $store.state.decks[findIndex].description }}</h3> -->
      </div>
    </div>

    <button
      type="button"
      class="createCard"
      @click="$router.push('/create-card')"
    >
      Add Card
    </button>
    <button
      type="button"
      class="viewSession"
      @click="$router.push('/view-session')"
    >
      Start Session
    </button>
    <!-- <td><input type="text" id="questionFilter" v-model="filter.question"/></td>
       <tr v-for="card in filteredList" v-bind:key="card.cardID" > -->

    <div
      class="cards"
      v-for="card in this.$store.state.cards"
      v-bind:key="card.cardID"
    >
      <div
        class="flip-box-inner"
        ontouchstart="this.classList.toggle('hover');"
      >
        <div class="flip-box-front">
          {{ card.question }}
        </div>
        <div class="flip-box-back">
          {{ card.answer }}
        </div>
      </div>
    </div>
    <!-- <div
      class="cards"
      v-for="card in this.$store.state.cards"
      v-bind:key="card.cardID"
    >
      {{ card.cardID }}
      {{ card.question }}
      {{ card.answer }}
      {{ card.rank }} -->
    <button
      type="button"
      class="updateCard"
      @click="
        $router.push({ name: 'update-card', params: { cardID: card.cardID } })
      "
    >
      EDIT
    </button>
    <button type="button" @click="removeCards(card.cardID)">DELETE</button>
    <!-- </tr> -->
  <div>
    
     <!-- <h2> {{ $store.state.decks[findIndex].name }} </h2>
      <h3> {{ $store.state.decks[findIndex].description }} </h3> -->
     
      <h1>Your card list</h1>
      
      <button type="button" class="createCard" @click="checkIf10Cards()">Add Card</button>
      <button type="button" class="viewSession" @click="$router.push('/view-session')">Start Session</button>
      <button type="button" class="viewSession" @click="$router.push('/view-session')">Start Lightning Round Session</button>
      <button type="button" class="viewSession" @click="$router.push('/view-session')">Start Random Session</button>
      <button type="button" class="createCard" @click="$router.push('/')">Choose Another Deck</button>
      <!-- <td><input type="text" id="questionFilter" v-model="filter.question"/></td>
       <tr v-for="card in filteredList" v-bind:key="card.cardID" > -->
        <tr class="cards"
        v-for="card in this.$store.state.cards" 
        v-bind:key="card.cardID">
        <td> {{ card.cardID }} </td>
       <td> {{ card.question }} </td>
       <td> {{ card.answer }} </td>
       <td> Rank: {{cardRank(card.rank)}}</td>
        <button type="button" class="updateCard" @click="$router.push({name: 'update-card', params:{cardID: card.cardID}})">EDIT</button>
        <button type="button" @click="removeCards(card.cardID)">DELETE</button>
        <!-- </tr> -->
        </tr>
  </div>
</template>

<script>
import authService from "../services/AuthService";
// import Search from '../components/Search.vue'
export default {
  components: {},
  data() {
    return {
      // filter: {
      //   question: '',
      //   answer: ''
      // },
      card: {
        deckID: this.$store.state.currentDeckID,
        question: "",
        answer: "",
        rank: "",
      },
    };
  },
  created() {
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
      let ID = "";
      this.$store.state.decks.forEach((deck) => {
        if (deck.deckID == this.$store.state.currentDeckID) {
          ID = this.$store.state.decks.indexOf(deck);
        }
      });
      return ID;
    },
  },
  name: "card-list",
  methods: {
    cardRank(rank) {
      let skillLevel = "";
      if (rank === 1) {
        skillLevel = "Novice";
      } else if (rank === 2) {
        skillLevel = "Intermediate";
      } else if (rank === 3) {
        skillLevel = "Advanced";
      } else if (rank === 4) {
        skillLevel = "Expert";
      } else if (rank === 5) {
        skillLevel = "Master";
      } else {
        skillLevel = "Beginner";
      }
      return skillLevel;
    },
    checkIf10Cards() {
      if (this.$store.state.cards.length == 10) {
        alert("Decks can not have more than 10 cards!");
      } else {
        this.$router.push("/create-card");
      }
    },
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
          //this.$router.push({name: 'deck-with-cards', params: {deckID: this.card.deckID}});
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

.cards {
  background-color: transparent;
  width: 300px;
  height: 200px;
  border: 1px solid #f1f1f1;
  perspective: 1000px; /* Remove this if you don't want the 3D effect */
}

/* This container is needed to position the front and back side */
.flip-box-inner {
  position: relative;
  width: 100%;
  height: 100%;
  text-align: center;
  transition: transform 0.8s;
  transform-style: preserve-3d;
}

/* Do an horizontal flip when you move the mouse over the flip box container */
.cards:hover .flip-box-inner {
  transform: rotateY(180deg);
}

/* Position the front and back side */
.flip-box-front,
.flip-box-back {
  position: absolute;
  width: 100%;
  height: 100%;

  backface-visibility: hidden;
}

/* Style the front side */
.flip-box-front {
  background-color: #bbb;
}

/* Style the back side */
.flip-box-back {
  background-color: dodgerblue;

  transform: rotateY(180deg);
}
</style>