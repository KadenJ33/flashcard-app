<template>
  <div class="page">
    <div class="wrapper">
      <div class="clip-text clip-text_thirteen clip-text--cover">
        Create Deck
      </div>
    </div>
    <form v-on:submit.prevent>
      <input type="text" id="answer" placeholder="Name" />
      <button type="submit" @click="newDeck()">Submit</button>
    </form>
  </div>
</template>
<script>
import authService from "../services/AuthService";
export default {
  data() {
    return {
      deck: {
        userId: "1",
        name: "HELPME",
      },
    };
  },
  methods: {
    newDeck() {
      authService
        .addDeck(this.deck)
        .then((response) => {
          console.log("HERE");
          if (response.status == 201) {
            this.$router.push("/");
          }
        })
        .catch((error) => {
          console.error(error);
        });
    },
  },
};
</script>

<style scoped>
form {
  text-align: center;
  padding-top: 20px;
}
label {
  padding-right: 16px;
}
input {
  font-family: "Roboto", sans-serif;
  width: 200px;
  margin: 20px auto;
  background: linear-gradient(to right, #ffffff 0%, #fafafa 50%, #ffffff 99%);
  border-radius: 10px;
}

button {
  font-family: "Roboto", sans-serif;
  width: 100px;
  margin-right: 10px;
  background-color: rgba(255, 255, 255, 1);
  border-radius: 10px;
}
.page {
  position: fixed;
  z-index: -3;

  background-image: linear-gradient(
    0deg,
    rgb(252, 220, 226) 9%,
    rgba(255, 255, 255, 1) 64%
  );
  min-height: 100%;
  min-width: 1024px;

  width: 100%;
  height: auto;

  top: 0;
  left: 0;
}
.wrapper {
  text-align: center;
  padding-top: 150px;
}

/* Clip text element */
.clip-text {
  font-size: 6em;
  font-weight: bold;
  line-height: 1;
  position: relative;
  display: inline-block;
  margin: 0.25em;
  padding: 0.5em 0.75em;
  text-align: center;
  color: #fff;
  -webkit-background-clip: text;

  -webkit-text-fill-color: transparent;
}

.clip-text:before,
.clip-text:after {
  position: absolute;
  content: "";
}

.clip-text:before {
  z-index: -2;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  background-image: inherit;
}

.clip-text:after {
  position: absolute;
  z-index: -1;
  top: 0.125em;
  right: 0.125em;
  bottom: 0.125em;
  left: 0.125em;
  background-color: #000;
  opacity: 0.8;
}

.clip-text--cover,
.clip-text--cover:before {
  background-size: cover;
  background-position: 50% 50%;
}

.clip-text_thirteen {
  background-image: url(https://img.freepik.com/free-photo/colorful-notebooks-felt-tip-pens-with-cellphone-laptop-cream-background_23-2147880646.jpg?size=626&ext=jpg);
}
</style>