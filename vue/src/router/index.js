import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import CreateDeck from '../views/CreateDeck.vue'
import  DeckWithCards from '../views/DeckWithCards.vue'
import CreateCard from '../views/CreateCard.vue'
import Session from '../views/ViewSession.vue'
import UpdateCard from '../views/UpdateCard.vue'
import UpdateDeck from '../views/UpdateDeck.vue'
import Results from '../views/ViewResults.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/create-deck",
      name: "create-deck",
      component: CreateDeck,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/deck-with-cards/:deckID",
      name: "deck-with-cards",
      component: DeckWithCards,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/create-card",
      name: "create-card",
      component: CreateCard,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/view-session/",
      name: "view-session",
      component: Session,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/update-card/:cardID",
      name: "update-card",
      component: UpdateCard,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/update-deck/:deckID",
      name: "update-deck",
      component: UpdateDeck,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/view-results/",
      name: "view-results",
      component: Results,
      meta: {
        requiresAuth: true
      }
    },
  
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
