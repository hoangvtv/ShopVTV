<template>
  <div class="text-center">
    <v-overlay :value="overlay" class="overlay">
      <div class="">
        <div><i class="fas fa-check-circle overlay__icon"></i></div>
        <span class="overlay__content">{{ text }}</span>
      </div></v-overlay
    >
  </div>
</template>

<script>
import { EventBus } from "../main.js";
export default {
  created() {
    EventBus.$on("openOverlay", this.openOverlay);
    EventBus.$on("getNotification", this.openNotification);
    EventBus.$on("sentToText", this.openEmptyCart);
  },
  data: () => ({
    overlay: false,
    text: "",
  }),

  watch: {
    overlay(val) {
      val &&
        setTimeout(() => {
          this.overlay = false;
        }, 1000);
    },
  },
  methods: {
    openOverlay(e) {
      this.overlay = !this.overlay;
      this.text = e;
    },
    openNotification(e) {
      this.overlay = !this.overlay;
      this.text = e;
    },
    openEmptyCart(e) {
      this.overlay = !this.overlay;
      this.text = e;
    },
  },
};
</script>

<style>
.overlay {
  width: 300px;
  height: 200px;
  margin: auto;
}
.overlay__icon {
  font-size: 50px;
}
</style>
