<template>
  <v-app>
    <com-header />
    <v-main>
      <router-view />
    </v-main>
    <com-sletter />
    <com-footer />
    <comp-add />
  </v-app>
</template>

<script>
import ComSletter from "./components/ComSletter.vue";
import ComFooter from "./views/ComFooter.vue";
import ComHeader from "./views/ComHeader.vue";
import CompAdd from "./components/CompAdd.vue";
export default {
  components: {
    ComHeader,
    ComSletter,
    ComFooter,
    CompAdd,
  },

  data: () => ({
    //
  }),
};
</script>

<style>
* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}
.v-application ol,
.v-application ul {
  padding-left: 0px !important;
}
.v-application a {
  color: #000 !important;
}
.v-application a:hover {
  color: blueviolet !important;
}
</style>
