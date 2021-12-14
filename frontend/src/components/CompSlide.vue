<template>
  <v-carousel
    cycle
    height="800px"
    :show-arrows="false"
    hide-delimiter-background
    delimiter-icon="mdi-line"
  >
    <v-carousel-item
      class="slide__img"
      v-for="(item, i) in items"
      :key="i"
      :src="item.src"
    ></v-carousel-item>
  </v-carousel>
</template>
<script>
export default {
  data() {
    return {
      items: [
        {
          src: "https://zuynshop.netlify.app/static/media/S5.b6483f02.jpg",
        },
        {
          src: "https://zuynshop.netlify.app/static/media/S2.3ce1c63d.jpg",
        },
        {
          src: "https://zuynshop.netlify.app/static/media/S4.aca49c89.jpg",
        },
      ],
    };
  },
};
</script>

<style>
.slide__img {
  animation: zoomIn ease-in 6s;
}
@keyframes zoomIn {
  from {
    transform: scale(1s);
  }
  to {
    transform: scale(1.05, 1.05);
  }
}
</style>
