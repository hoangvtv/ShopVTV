<template>
  <div class="productDetail">
    <div class="productDetail__left">
      <div class="card" style="width: 400px">
        <img
          class="card-img-top left__img"
          :src="product.hinhAnh"
          style="width: 100%; height: 100%"
          alt="Cart-image"
        />
        <div class="card-header">{{ product.tenSanPham }}</div>
        <div class="card-body">Description: {{ product.moTa }}</div>
        <div class="card-footer">Price: {{ product.giaSanPham }}$</div>
      </div>
    </div>
    <div class="productDetail__right">
      <div class="right__info">
        <div class="card">
          <div class="card-header">
            <p>
              Price: <span>${{ product.giaSanPham }}</span>
            </p>
          </div>
          <div class="card-body">
            <p>Status: <span>In Stock</span></p>
          </div>
          <div class="card-footer">
            <p>
              <button
                type="button"
                class="btn btn-dark right__btn"
                @click="setListCart(product)"
              >
                Add to Cart
              </button>
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { EventBus } from "../main.js";
import axios from "axios";
export default {
  created() {
    this.sanPhamId = this.$route.params.id;
    this.getSpById();
  },

  data() {
    return {
      sanPhamId: null,
      product: {},
      add: "Sản phẩm đã được thêm vào giỏ hàng",
    };
  },
  methods: {
    setListCart(product) {
      this.$store.commit("ADD_PRODUCTS", product);
      EventBus.$emit("openOverlay", this.add);
    },
    getSpById() {
      axios
        .get(
          `http://localhost:8888/sanPham/chitietSanPham?maSp=${this.sanPhamId}`
        )
        .then((response) => {
          this.product = response.data;
        });
    },
  },
};
</script>

<style>
.productDetail {
  margin-top: 150px;
  display: flex;
  justify-content: center;
  margin-bottom: 50px;
}
.productDetail__left {
  margin-right: 20px;
}
.left__img {
  margin-bottom: 20px;
}
.right__quantity input {
  border-bottom: 1px solid rgba(0, 0, 0, 0.5);
}
.right__btn {
  color: white !important;
}
</style>
