import Vue from 'vue'
import App from './App.vue'

import * as VueGoogleMaps from "vue2-google-maps" // Import package

Vue.config.productionTip = false

Vue.use(VueGoogleMaps, {
  load: {
    key: "AIzaSyDSftU2lalfMmgzx5M5sob7BaQ78Fr5ekE",
    libraries: "places"
  }
});

new Vue({
  render: h => h(App),
}).$mount('#app')