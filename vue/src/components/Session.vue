<template>
  <div class="page">
    <div class="wrapper">
      <div class="clip-text clip-text_thirteen clip-text--cover">
        Study Session
      </div>
    </div>

    <div class="container">
      <div class="flip-card">
        <div class="flip-card-inner">
          <div class="flip-card-front">
            <div>{{ this.$store.state.cards[currentCardIndex].question }}</div>
          </div>
          <div class="flip-card-back">
            <div>
              {{ this.$store.state.cards[currentCardIndex].answer }}
            </div>
          </div>
        </div>
      </div>
    </div>

    <button type="button" class="delete-icon" v-on:click="getNextCard()">
      NEXT CARD
    </button>
    <br />
    <button v-on:click="markCorrect()">Mark Correct</button>
    <br />
    <button v-on:click="endSession()">End Session</button>
    <br />
    <button
      type="button"
      class="viewResults"
      @click="$router.push('/view-results')"
    >
      View Results
    </button>
  </div>
</template>

<script>
import authService from "../services/AuthService";
export default {
  data() {
    return {
      currentCardIndex: 0,
      isCorrect: false,
      correctNumber: 0,
    };
  },
  created() {
    this.$store.commit("SET_NUMBER_OF_CORRECT", this.correctNumber);
  },
  methods: {
    changeCardIndex() {
      if (this.currentCardIndex + 1 <= this.$store.state.cards.length - 1) {
        this.currentCardIndex += 1;
      } else {
        this.endSession();
      }
    },
    toggleCard(card) {
      card.flipped = !card.flipped;
    },
    markCorrect() {
      this.isCorrect = true;
    },
    getNextCard() {
      if (this.isCorrect == true) {
        this.update(this.$store.state.cards[this.currentCardIndex].cardID);
        this.correctNumber += 1;
      }
      this.$store.commit("SET_NUMBER_OF_CORRECT", this.correctNumber);
      this.changeCardIndex();
      this.isCorrect = false;
    },
    endSession() {
      this.$router.push("/view-results");
    },
    update(id) {
      authService
        .markCardCorrect(id)
        .then((response) => {})
        .catch((error) => {
          console.error(error);
        });
    },
  },
  computed: {},
};
</script>

<style>
body {
  font-family: "Montserrat", sans-serif;
}

p {
  align-content: center;
  list-style-type: none;
  padding: 10px 10px;
  transition: all 0.3s ease;
}

.container {
  max-width: 100%;
  padding: 1em;
}

.card {
  display: block;
  width: 650px;
  height: 350px;
  padding: 80px 50px;
  background-color: #51aae5;
  border-radius: 7px;
  margin: 20%;
  text-align: center;
  line-height: 27px;
  cursor: pointer;
  position: relative;
  color: #fff;
  font-weight: 600;
  font-size: 20px;
  -webkit-box-shadow: 9px 10px 22px -8px rgba(209, 193, 209, 0.5);
  -moz-box-shadow: 9px 10px 22px -8px rgba(209, 193, 209, 0.5);
  box-shadow: 9px 10px 22px -8px rgba(209, 193, 209, 0.5);
  will-change: transform;
}

p:hover {
  transform: scale(1.1);
}

p:nth-child(-n + 3) .card {
  background-color: #e65f51;
}

p:nth-child(2n + 1) .card {
  background-color: #a17de9;
}

p:nth-child(4n) .card {
  background-color: #feca34;
}

p:nth-child(5n-2) .card {
  background-color: #51aae5;
}

p:nth-child(4n + 4) .card {
  background-color: #feca34;
}

p:nth-child(-7n + 7) .card {
  background-color: #e46055;
}

.correct {
  position: absolute;
  right: 0;
  top: 0;
  padding: 10px 15px;
  opacity: 0.4;
  transition: all 0.5s ease;
}

.correct:hover {
  opacity: 1;
}

.flip-enter-active {
  transition: all 0.4s ease;
}

.flip-leave-active {
  display: none;
}

.flip-enter,
.flip-leave {
  transform: rotateY(180deg);
  opacity: 0;
}

.page {
  position: absolute;
  z-index: -3;

  background-image: linear-gradient(
    0deg,
    rgb(252, 220, 226) 9%,
    rgba(255, 255, 255, 1) 64%
  );
  min-height: 100%;
  min-width: 1024px;

  width: 100%;
  height: auto;

  top: 0;
  left: 0;
}

.wrapper {
  text-align: center;
  position: relative;
  padding-top: 50px;
}

.clip-text {
  font-size: 5em;
  font-weight: bold;
  line-height: 1;
  position: relative;
  display: inline-block;
  margin: 0.45em;
  padding: 0.5em 0.75em;
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

/* The flip card container - set the width and height to whatever you want. We have added the border property to demonstrate that the flip itself goes out of the box on hover (remove perspective if you don't want the 3D effect */
.flip-card {
  background-color: transparent;
  width: 300px;
  height: 200px;
  border: 1px solid #f1f1f1;
  perspective: 1000px; /* Remove this if you don't want the 3D effect */
}

/* This container is needed to position the front and back side */
.flip-card-inner {
  position: relative;
  width: 100%;
  height: 100%;
  text-align: center;
  transition: transform 0.8s;
  transform-style: preserve-3d;
}

/* Do an horizontal flip when you move the mouse over the flip box container */
.flip-card:hover .flip-card-inner {
  transform: rotateY(180deg);
}

/* Position the front and back side */
.flip-card-front,
.flip-card-back {
  position: absolute;
  width: 100%;
  height: 100%;
  -webkit-backface-visibility: hidden; /* Safari */
  backface-visibility: hidden;
}

/* Style the front side (fallback if image is missing) */
.flip-card-front {
  background-color: #bbb;
  color: black;
}

/* Style the back side */
.flip-card-back {
  background-color: dodgerblue;
  color: white;
  transform: rotateY(180deg);
}
</style>