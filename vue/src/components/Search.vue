<template>
   <div class="search-box">
       <input
      v-model="search"
      @keyup="searchCards"
      type="text"
      class="input"
      placeholder="Search"
    />
    </div>
</template>

<script>
export default {
    name: "Search",
  data() {
    return {
      search: this.search || ""
    };
  },
  methods: {
    searchCards() {
      this.$emit("searchTrigger", this.search);
    }
  }
};
</script>
<style  scoped>

</style>