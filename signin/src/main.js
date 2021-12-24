import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

import GAuth from 'vue-google-oauth2'
const gauthOption = {
  //Configure the Google+ API
  clientId: '565044298562-o82m6vi24ua36l2fts271pagkiasekh1.apps.googleusercontent.com',
  scope: 'profile email',
  prompt: 'consent',
  fetch_basic_profile: true
}
Vue.use(GAuth, gauthOption)

new Vue({
  render: h => h(App),
}).$mount('#app')
