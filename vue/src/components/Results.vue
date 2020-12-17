<template>
  <div>
    <h1>
      You got {{ $store.state.numberOfCorrect }} out of
      {{ $store.state.cards.length }} flashcards right.
    </h1>
    <button
      id="view-deck"
      type="button"
      @click="
        $router.push({
          name: 'deck-with-cards',
          params: { deckID: $store.state.currentDeckID },
        })
      "
    >
      Return To Deck
    </button>
  </div>
</template>

<script>
export default {
  name: "results",
};
</script>

<style scoped>
div {
  position: absolute;

  background-image: url("https://img.freepik.com/free-vector/congratulations-poster-with-fireworks-explosions-background_95561-60.jpg?size=626&ext=jpg");
  min-height: 100%;
  min-width: 100%;

  width: 100%;
  height: auto;
}
</style>