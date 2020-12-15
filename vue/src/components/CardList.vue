<template>
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

    <div
      class="cards"
      v-for="card in this.$store.state.cards"
      v-bind:key="card.cardID"
    >
      {{ card.cardID }}
      {{ card.question }}
      {{ card.answer }}
      {{ card.rank }}
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";
import Search from "../components/Search.vue";
export default {
  components: {
    search: Search,
  },
  data() {
    return {
      card: {
        deckID: 0,
        question: "",
        answer: "",
      },
    };
  },

  created() {
    this.retrieveCards();
  },
  name: "card-list",
  methods: {
    retrieveCards() {
      authService.getCards(this.$store.state.decks.deckID).then((response) => {
        this.$store.commit("SET_CARDS", response.data);
      });
    },
    removeCards(cardID) {
      authService.deleteCard(cardID).then((response) => {
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
</style>