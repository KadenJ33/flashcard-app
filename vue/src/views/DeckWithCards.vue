<template>
  <div class="cards">
<<<<<<< HEAD
    <card-list />
=======
   <!-- <search /> -->
      <card-list />
>>>>>>> a28dda07cd7de3a29a16d6f06bd2250e9d797a8e
  </div>
</template>

<script>
<<<<<<< HEAD
import CardList from "../components/CardList.vue";
export default {
  name: "deck-with-cards",
  components: {
    CardList,
  },
};
=======
import CardList from '../components/CardList.vue'
//import Search from '@/components/Search.vue';
export default {
    name: "deck-with-cards",
    components: {
      //'search': Search,
    'card-list': CardList
 },
}
>>>>>>> a28dda07cd7de3a29a16d6f06bd2250e9d797a8e
</script>

<style>
</style>