<template>
  <div>
      <h1>
         You got {{$store.state.numberOfCorrect}} out of {{$store.state.cards.length}} flashcards right.
      </h1>
      <button id="view-deck" type="button" @click="$router.push({
   name: 'deck-with-cards', params: {deckID: $store.state.currentDeckID }})">Return To Deck</button>
  </div>
</template>

<script>
export default {

name: 'results',

}
</script>

<style>

</style>