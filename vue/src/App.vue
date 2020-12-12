<template>
  <div id="app">
    <div id="nav">
      <ul>
        <li class="home">
          <router-link v-bind:to="{ name: 'home' }">Home</router-link
          >&nbsp;|&nbsp;
        </li>
        <li class="logout">
          <router-link
            v-bind:to="{ name: 'logout' }"
            v-if="$store.state.token != ''"
            >Logout</router-link
          >
        </li>
      </ul>
    </div>
    <router-view />
  </div>
</template>

<style>
</style>
