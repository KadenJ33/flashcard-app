<template>
  <div class="home">
    <p>You must be authenticated to see this</p>
    <deck-list />
    <!-- <div class="button">
      
      <button class="edit" @click="$router.push('edit')">Edit Deck</button>
      <button class="delete" @click="$router.push('delete')">Delete Deck</button>
      </div> -->
  </div>
</template>

<script>
import DeckList from '@/components/DeckList.vue';

export default {
  name: "home",
  components: {
    DeckList
 }
};
</script>

