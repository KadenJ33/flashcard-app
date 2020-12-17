<template>
  <div class="page">
     <div class="wrapper">
        <div class="clip-text clip-text_thirteen clip-text--cover">
           Results!
        </div>
     </div>
      <h1>
         You got {{$store.state.numberOfCorrect}} out of {{$store.state.cards.length}} flashcards right.
      </h1>
      <button @click="celebrate()">CELEBRATE!</button>
      <button id="view-deck" type="button" @click="$router.push({
   name: 'deck-with-cards', params: {deckID: $store.state.currentDeckID }}, stopConfetti())">Return To Deck</button>
  </div>
</template>

<script>
import Vue from 'vue'
import VueConfetti from 'vue-confetti'
 
  Vue.use(VueConfetti)
export default {
name: 'results',


methods: {
   stopConfetti() {
      this.$confetti.stop();
   }, 
   celebrate() {
      
      this.$confetti.update({
          particles: [
            {
              type: 'heart',
            },
            {
              type: 'circle',
            },
          ],
          defaultColors: [
            'red',
            'pink',
            '#ba0000'
          ],
        });
        this.$confetti.start();
   }
}
}
</script>

<style>
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
</style>