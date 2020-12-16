<template>
  <div class="cards">
    <card-list />
  </div>
</template>

<script>
import CardList from "../components/CardList.vue";

export default {
  name: "deck-with-cards",
  components: {
    "card-list": CardList,
  },
};
</script>

<style>
</style>