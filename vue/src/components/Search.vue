<template>
  <div class="search-box">
    <td><input type="text" id="questionFilter" v-model="filter.question" /></td>
    <tr v-for="card in filteredList" v-bind:key="card.cardID"></tr>
  </div>
</template>

<script>
export default {
  name: "Search",
  data() {
    return {
      filter: {
        question: "",
        answer: "",
      },
      search: this.search || "",
    };
  },
  computed: {
    filteredList() {
      let filteredCards = this.$store.state.cards;
      if (this.filter.question != "") {
        filteredCards = filteredCards.filter((card) =>
          card.question
            .toLowerCase()
            .includes(this.filter.question.toLowerCase())
        );
      }
      if (this.filter.answer != "") {
        filteredCards = filteredCards.filter((card) =>
          card.answer.toLowerCase().includes(this.filter.answer.toLowerCase())
        );
      }
      return filteredCards;
    },
    methods: {
      searchCards() {
        this.$emit("searchTrigger", this.search);
      },
    },
  },
};
</script>
<style  scoped>
.search-box {
  position: relative;
  display: center;
  min-width: 100px;
  text-align: center;
  top: 0px;
}
.search-icon {
  position: absolute;
  top: 5px;
  left: 540px;
  width: 14px;
}
.input {
  border: 1px solid grey;
  border-radius: 5px;
  height: 20px;
  width: 20%;
  padding: 2px 23px 2px 30px;
  outline: 0;
  background-color: #f5f5f5;
}
.input:hover,
.input:focus {
  border: 1.5px solid #009688;
  background-color: white;
}
</style>