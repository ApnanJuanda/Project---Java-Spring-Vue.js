<template>
  <div>
    <br />
    <h1>Google Maps Multiple Markers</h1>

    <gmap-map :center="center" :zoom="12" style="width: 100%; height: 400px">
      <gmap-marker
        :key="index"
        v-for="(m, index) in markers"
        :position="m"
        @click="center = m"
      ></gmap-marker>
    </gmap-map>
  </div>
</template>

<script>
export default {
  name: "GoogleMap",
  data() {
    return {
      center: { lat: -6.960848, lng: 107.966894 },
      markers: [],
      currentPlace: null,
    };
  },

  mounted() {
    this.geolocate();
  },

  methods: {
    setPlace(place) {
      this.currentPlace = place;
    },
    geolocate: function () {
      navigator.geolocation.getCurrentPosition((position) => {
        this.center = {
          lat: position.coords.latitude,
          lng: position.coords.longitude,
        };
      });

      this.markers = [
        {
          lat: -92.587825,
          lng: 21.895907,
          label: "Location 2",
        },
      ];
    },
  },
};
</script>
