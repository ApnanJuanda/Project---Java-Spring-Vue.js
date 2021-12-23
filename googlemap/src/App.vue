<template>
   <div id="app">
      <map-marker />
   </div>
</template>
 
<script>
import MapMarker from "./components/MapMarker";

export default {
  name: 'App',
  components: {
    MapMarker
    
  }
}
</script>
 
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #000000;
  margin-top: 50px;
}
</style>