<template>
  <div class="home">
    <view-decks />
    
    <!-- <router-view :key="$route.fullPath" class="routerView" /> -->
    <!-- <div class="button">
      
      <button class="edit" @click="$router.push('edit')">Edit Deck</button>
      <button class="delete" @click="$router.push('delete')">Delete Deck</button>
      </div> -->
  </div>
</template>

<script>
<<<<<<< HEAD
import ViewDecks from "@/views/ViewDecks.vue";
// import Search from '@/components/Search.vue';
=======
import ViewDecks from '@/views/ViewDecks.vue';

>>>>>>> a28dda07cd7de3a29a16d6f06bd2250e9d797a8e

export default {
  name: "home",
  components: {
    ViewDecks,
<<<<<<< HEAD
    // Search
  },
=======
    
 }
>>>>>>> a28dda07cd7de3a29a16d6f06bd2250e9d797a8e
};
</script>


