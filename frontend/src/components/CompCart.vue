<template>
  <div class="cart__heading">
    <h1 class="cart__title">Cart</h1>
    <div class="cart__content">
      <div class="cart" v-for="product in listCarts" :key="product.sanPhamId">
        <div class="cart__img">
          <img :src="product.hinhAnh" alt="product" />
        </div>
        <div class="cart__info">
          <router-link :to="`/product/${product.sanPhamId}`">{{
            product.tenSanPham
          }}</router-link>
        </div>
        <div class="cart__price">
          <p>${{ product.giaSanPham }}</p>
        </div>
        <div class="cart__quantity">
          <input type="number" min="1" placeholder="1" />
        </div>
        <div class="cart__delete">
          <button
            type="button"
            class="btn btn-dark"
            @click="deleteProduct(product.sanPhamId)"
          >
            Delete
          </button>
        </div>
      </div>
    </div>
    <div class="cart__priceTotal">
      <div class="priceTotal">
        <div class="">
          <h6>Total: ${{ totalpriceCart }}</h6>
        </div>
        <div>
          <button
            type="button"
            class="btn btn-dark"
            style="color: #fff"
            @click="sendToPrice"
          >
            Checkout
          </button>
        </div>
      </div>
    </div>
    <comp-checkout />
  </div>
</template>

<script>
import { EventBus } from "../main.js";
import { mapGetters } from "vuex";
import CompCheckout from "../components/CompCheckout.vue";
export default {
  components: {
    CompCheckout,
  },
  computed: {
    listCarts() {
      return this.$store.state.listCartProducts;
    },
    ...mapGetters(["getCart"]),
  },
  created() {
    this.totalPrice();
  },
  watch: {
    getCart() {
      this.totalpriceCart = 0;
      this.getCart.forEach((x) => {
        this.totalpriceCart += x.giaSanPham;
      });
    },
    listCarts: {
      deep: true,
      handler() {
        console.log("The list of changed");
        this.totalPrice();
      },
    },
  },
  data: () => ({
    totalpriceCart: 0,
    listCart: [],
    text: "Bạn chưa thêm sản phẩm nào vào giỏ hàng",
  }),
  methods: {
    deleteProduct(productId) {
      this.$store.commit("DELETE_PRODUCTS", productId);
    },
    totalPrice() {
      this.getCart.forEach((x) => {
        this.totalpriceCart += x.giaSanPham;
      });
    },
    sendToPrice() {
      if (this.totalpriceCart > 0) {
        EventBus.$emit("sentToPriceTotal", this.totalpriceCart);
      } else {
        EventBus.$emit("sentToText", this.text);
      }
    },
  },
};
</script>

<style>
.cart__heading {
  margin-top: 150px;
}
.cart__title {
  margin-left: 50px;
}
.cart {
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 20px auto 14px;
  border: 1px solid #333;
  overflow: hidden;
  max-height: 200px;
  max-width: 100vh;
}
.cart__img img {
  padding: 0;
  height: 100%;
  width: 200px;
  vertical-align: middle;
}
.cart__info {
  margin: 10px;
  padding: 10px 17px;
}
.cart__price {
  margin: 0 20px;
  display: flex;
}
.cart__quantity {
  border-bottom: 1px solid #ccc;
}
.cart__delete {
  color: #fff !important;
  margin: 0 20px;
}
.priceTotal {
  display: flex;
  justify-content: space-evenly;
  z-index: 1;
  margin: 30px 0;
}
</style>
