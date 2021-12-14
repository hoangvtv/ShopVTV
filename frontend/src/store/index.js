import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

import axios from "axios";
export default new Vuex.Store({
  state: {
    listProducts: [],
    listCartProducts: [],
  },
  getters: {
    getCart: (state) => state.listCartProducts,
  },
  mutations: {
    TOTAL_PRICES(state, total) {
      state.listCartProducts.filter((x) => (total += x.giaSanPham));
    },
    SET_PRODUCTS(state, products) {
      state.listProducts = products;
    },
    ADD_PRODUCTS(state, product) {
      let check = true;
      state.listCartProducts.forEach((x) => {
        if (x.sanPhamId === product.sanPhamId) {
          check = false;
        }
      });
      if (check === true) {
        state.listCartProducts.push(product);
      }
    },
    DELETE_PRODUCTS(state, productId) {
      state.listCartProducts = state.listCartProducts.filter(
        (x) => x.sanPhamId !== productId
      );
    },
  },
  actions: {
    async getProducts({ commit }) {
      try {
        const response = await axios.get(
          "http://localhost:8888/sanPham/dsSanPham"
        );
        commit("SET_PRODUCTS", response);
      } catch (error) {
        console.log(error);
      }
    },
  },
  modules: {},
});
