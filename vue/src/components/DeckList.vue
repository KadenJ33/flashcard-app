<template>
  <div>
    <h1>Your Deck List</h1>
    <button class="createDeck" @click="$router.push('create-deck')">Create Deck</button>
  </div>
  
</template>

<script>


export default {
  name: "deck-list"
}
</script>

<style>

</style>