<template>
  <div class="page">
    <div id="login" class="text-center">
      <form class="form-signin" @submit.prevent="login">
        <h1 class="h3 mb-3 font-weight-normal">Welcome to Flashcards App</h1>
        <div class="header-img"></div>
        <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div
          class="alert alert-success"
          role="alert"
          v-if="this.$route.query.registration"
        >
          Thank you for registering, please sign in.
        </div>
        <label for="username" class="sr-only">Username</label>
        <input
          type="text"
          id="username"
          class="form-control"
          placeholder="Username"
          v-model="user.username"
          required
          autofocus
        />
        <label for="password" class="sr-only">Password</label>
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required
        />
        <button class="btn btn-lg btn-primary btn-block" type="submit">
          Login
        </button>
        <router-link :to="{ name: 'register' }">Need an account?</router-link>
      </form>
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style scoped>
.page {
  background-image: url("https://www.herzing.edu/sites/default/files/styles/fp_960_480/public/images/blog/study_space_desk.png?h=6eb229a4&itok=2z-Rm9ka");
  min-height: 100%;
  min-width: 1024px;

  width: 100%;
  height: 100%;

  top: 0;

  position: fixed;
  background-repeat: no-repeat;
  background-size: cover;
}
h1 {
  padding-top: 100px;
  font-size: 48px;
  color: white;
}
input {
  font-family: "Roboto", sans-serif;
  width: 400px;
  margin: 20px auto;
  background: linear-gradient(to right, #ffffff 0%, #fafafa 50%, #ffffff 99%);
  border-radius: 10px;
}

button {
  font-family: "Roboto", sans-serif;
  width: 400px;
  margin: 10px auto;
}

a {
  border-radius: 10px;
  background: white;
  padding: 10px;
  width: 200px;
  height: 100px;
}
</style>

