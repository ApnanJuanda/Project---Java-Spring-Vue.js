<template>
  <div id="app">
    <h3>VueJS Google Signin</h3>
    <button @click="login()">Login with Google</button>  
    Status Login: ? {{isLogin}}
    <button @click="logout()">Logout</button>
  </div>

</template>

<script>
export default {
  name: "App",
  data(){
    return{
      isLogin: false
    }
  },
  methods: {
    async login(){
      const googleUser = await this.$gAuth.signIn();
      console.log("googleUser: ", googleUser);
      this.isLogin = this.$gAuth.isAuthorized;
    },
    async logout(){
      const result = await this.$gAuth.signOut();
      console.log("result from logout: ", result);
      this.isLogin = false;
    }
  }
}
</script>



<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
