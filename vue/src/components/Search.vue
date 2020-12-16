<template>
  <div class="search-box">
    <img
      class="search-icon"
      src="data:image/svg+xml;utf8;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pgo8IS0tIEdlbmVyYXRvcjogQWRvYmUgSWxsdXN0cmF0b3IgMTkuMC4wLCBTVkcgRXhwb3J0IFBsdWctSW4gLiBTVkcgVmVyc2lvbjogNi4wMCBCdWlsZCAwKSAgLS0+CjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4PSIwcHgiIHk9IjBweCIgdmlld0JveD0iMCAwIDU2Ljk2NiA1Ni45NjYiIHN0eWxlPSJlbmFibGUtYmFja2dyb3VuZDpuZXcgMCAwIDU2Ljk2NiA1Ni45NjY7IiB4bWw6c3BhY2U9InByZXNlcnZlIiB3aWR0aD0iMTZweCIgaGVpZ2h0PSIxNnB4Ij4KPHBhdGggZD0iTTU1LjE0Niw1MS44ODdMNDEuNTg4LDM3Ljc4NmMzLjQ4Ni00LjE0NCw1LjM5Ni05LjM1OCw1LjM5Ni0xNC43ODZjMC0xMi42ODItMTAuMzE4LTIzLTIzLTIzcy0yMywxMC4zMTgtMjMsMjMgIHMxMC4zMTgsMjMsMjMsMjNjNC43NjEsMCw5LjI5OC0xLjQzNiwxMy4xNzctNC4xNjJsMTMuNjYxLDE0LjIwOGMwLjU3MSwwLjU5MywxLjMzOSwwLjkyLDIuMTYyLDAuOTIgIGMwLjc3OSwwLDEuNTE4LTAuMjk3LDIuMDc5LTAuODM3QzU2LjI1NSw1NC45ODIsNTYuMjkzLDUzLjA4LDU1LjE0Niw1MS44ODd6IE0yMy45ODQsNmM5LjM3NCwwLDE3LDcuNjI2LDE3LDE3cy03LjYyNiwxNy0xNywxNyAgcy0xNy03LjYyNi0xNy0xN1MxNC42MSw2LDIzLjk4NCw2eiIgZmlsbD0iIzAwMDAwMCIvPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8L3N2Zz4K"
    />
    <input
      v-model="search"
      @keyup="searchCards"
      type="text"
      class="input"
      placeholder="Search"
    />
  </div>
   <!-- <div class="search-box">
       <td><input type="text" id="questionFilter" v-model="filter.question"/></td>
       <tr v-for="card in filteredList" v-bind:key="card.cardID" >
        
        
       
      </tr>
    </div> -->
</template>

<script>
export default {
  name: "Search",
  data() {
    return {
      filter: {
        question: '',
        answer: ''
      },
      search: this.search || ""
    };
  },
   computed: {
    filteredList() {
      let filteredCards = this.$store.state.cards;
      if( this.filter.question != "" ) {
        filteredCards = filteredCards.filter(card => card.question.toLowerCase().includes(this.filter.question.toLowerCase()))
      } 
      if( this.filter.answer != "" ) {
        filteredCards = filteredCards.filter(card => card.answer.toLowerCase().includes(this.filter.answer.toLowerCase()))
      }
      return filteredCards;
    },
  methods: {
    searchCards() {
      this.$emit("searchTrigger", this.search);
    }
  }
  },
}
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