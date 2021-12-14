<template>
  <div class="text-center checkout">
    <v-overlay :value="overlay">
      <div class="checkout__container" @blur="overlay = !overlay">
        <div class="checkout__header">
          <h3 class="mt-3 ml-3">XÁC NHẬN</h3>
          <span class="item__close" @click="overlay = !overlay">
            <i class="fas fa-times p-0"></i
          ></span>
        </div>
        <div class="checkout__content">
          <input
            type="text"
            class="checkout__item"
            v-model="name"
            placeholder="Họ tên người nhận..."
          />
          <input
            type="email"
            v-model="address"
            class="checkout__item"
            placeholder="Địa chỉ..."
          />
          <input
            type="text"
            class="checkout__item"
            v-model="phone"
            placeholder="Số điện thoại..."
          />

          <input type="text" class="checkout__item" placeholder="Ghi chú..." />
        </div>
        <div class="checkout__btn mb-3">
          <h6>Tổng tiền: {{ totalPrice }}</h6>
          <button
            type="button"
            class="btn btn-success"
            @click="getNotification"
          >
            Đặt hàng
          </button>
        </div>
      </div>
    </v-overlay>
  </div>
</template>

<script>
import { EventBus } from "../main.js";
export default {
  created() {
    EventBus.$on("sentToPriceTotal", this.sendToPrice);
  },
  destroyed() {
    EventBus.$off("sentToPriceTotal", this.sendToPrice);
  },
  data: () => ({
    overlay: false,
    totalPrice: 0,

    name: "",
    phone: "",
    address: "",
    text: "Đặt hàng thành công",
    distext: "Bạn chưa nhập đủ thông tin",
  }),

  methods: {
    sendToPrice(e) {
      this.totalPrice = e.toLocaleString("vi", {
        style: "currency",
        currency: "VND",
      });
      this.overlay = true;
    },

    getNotification() {
      if (this.name === "" || this.phone === "" || this.address === "") {
        EventBus.$emit("getNotification", this.distext);
      } else {
        EventBus.$emit("getNotification", this.text);

        setTimeout(() => {
          this.overlay = false;
        }, 1500);
      }
    },
  },
};
</script>
<style>
.checkout__container {
  background: white;
  width: 500px;
  color: black;
  border: 2px solid gray;
  border-radius: 5px;
}
.checkout__header {
  display: flex;
  justify-content: space-between;
}
.item__close {
  margin: 0;
  padding: 2px;
  cursor: pointer;
}
.checkout__content--item {
  margin: 10px 8px;
}
.checkout__item {
  width: 100%;
  line-height: 50px;
  margin-right: 20px;
  border-bottom: 1px solid #ddd;
  padding-left: 16px;
  margin-bottom: 20px;
}
.checkout__item:focus {
  outline: none;
}

.content--item--input {
  width: 100%;
}
</style>
