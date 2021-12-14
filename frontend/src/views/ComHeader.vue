<template>
  <header class="header">
    <!-- <div class="header__bar">
      <i class="fas fa-bars" @click="overlay = true"></i>
      <div class="">
        <v-overlay :value="overlay">
          <div class="header__mobile">
            <ul class="header__mobile--menu">
              <li class="header__mobile--menu__item">Trang chủ</li>
              <li class="header__mobile--menu__item">Sản phẩm</li>
              <li class="header__mobile--menu__item">Liên hệ</li>
            </ul>
          </div></v-overlay
        >
      </div>
    </div> -->
    <!-- <ul class="header__menu">
      <li class="menu-item">
        <router-link to="/" class="menu-item-link">Trang chủ</router-link>
      </li>
      <li class="menu-item">
        <router-link to="/product" class="menu-item-link">Sản phẩm</router-link>
      </li>
      <li class="menu-item">
        <router-link to="/contact" class="menu-item-link"> Liên hệ</router-link>
      </li>
    </ul> -->
    <v-tabs class="header__menu">
      <v-tab class="menu__item"
        ><router-link to="/" class="menu-item-link"
          >Trang chủ</router-link
        ></v-tab
      >
      <v-tab class="menu__item"
        ><router-link to="/product" class="menu-item-link"
          >Sản phẩm</router-link
        ></v-tab
      >
      <v-tab class="menu__item">
        <router-link to="/contact" class="menu-item-link">
          Liên hệ</router-link
        ></v-tab
      >
    </v-tabs>
    <div class="header__logo">
      <a href="/" class="header__logo-link">
        <img src="../assets/img/logo-bg.png" />
      </a>
    </div>
    <div class="header__wrap">
      <div class="header__icon">
        <form>
          <input
            v-if="check_input == true"
            type="text"
            placeholder="Tìm kiếm..."
            class="search__input"
            v-model="tenSp"
            @blur="handCheckInput"
          />
          <router-link to="/product"
            ><i class="fa fa-search header__icon-search" @click="search"></i
          ></router-link>
          <!-- <span class="header__icon icon_user">
            <i class="fas fa-user header__icon-cart"></i>
          </span> -->
          <router-link to="/cart" class="header__icon">
            <i class="fas fa-cart-plus header__icon-cart"></i>
            <span class="header__cart-notice">{{ quantityTotal }}</span>
          </router-link>
        </form>
      </div>
    </div>
  </header>
</template>

<script>
import { EventBus } from "../main.js";

export default {
  watch: {
    storeCart() {
      this.quantityTotal = this.storeCart.length;
    },
    tenSp() {
      EventBus.$emit("search", this.tenSp);
      if (this.tenSp === "") {
        EventBus.$emit("resetData");
      }
    },
  },

  computed: {
    storeCart() {
      return this.$store.state.listCartProducts;
    },
  },
  data() {
    return {
      overlay: false,
      quantityTotal: 0,
      tenSp: "",
      check_input: false,
    };
  },
  methods: {
    search() {
      this.check_input = !this.check_input;
      EventBus.$emit("search", this.tenSp);
    },
    handCheckInput() {
      this.check_input = !this.check_input;
    },
  },
};
</script>

<style>
* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}
.header {
  display: flex;
  position: fixed;
  top: 0;
  width: 100%;
  z-index: 9999;
  padding: 0 20px;
  background: hsla(0, 4%, 78%, 0);
  line-height: 85px;
  align-items: center;
}
.header:hover {
  background-color: #fff;
}
.header__bar {
  display: none;
}
.header__menu {
  height: 100px;
  display: flex;
  flex: 1 !important;
  padding-left: 0;
  position: relative;
  top: 25px;
  background-color: none !important;
}
.menu-item-link {
  line-height: 90px;
}
.theme--light.v-tabs > .v-tabs-bar {
  background-color: rgba(0, 0, 0, 0) !important;
}

.menu-item {
  list-style: none;
  /* text-decoration: none; */
  font-weight: 700;
  cursor: pointer;
  text-align: center;
  margin: 0 20px 0 0;
  /* color: #232323; */
  /* padding: 5px 0; */
}
.menu-item-link {
  text-decoration: none;
  color: #232323;
  font-size: 14px;
}

.header__logo {
  display: flex;
  align-items: center;
  justify-content: center;
  flex: 1;
}
.header__logo-img {
  vertical-align: middle;
}
.header__wrap {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  flex: 1;
}
.search__input {
  margin-right: 5px;
  height: 50px;
  animation: fadeIn ease-in 0.3s;
}

@keyframes fadeIn {
  from {
    opacity: 0;
    transform: translateX(calc(100% + 32px));
  }
  to {
    opacity: 1;
    transform: translateX(0);
  }
}

.search__input:focus {
  outline: none;
}

.header__icon-cart {
  padding: 0 0px 0 8px;
}
.header__icon {
  margin: 0 12px;
}
.header__icon:hover {
  cursor: pointer;
}
.header__cart-notice {
  /* line-height: 14px;
  font-size: 14px;
  border-radius: 50%; */
  margin-left: 5px;
  font-weight: bold;
  font-weight: 700;
  /* border: 2px solid #ee4d2d; */
}

@media (max-width: 1023px) {
  .header__menu {
    display: none;
  }
  .header__bar {
    display: block;
  }

  .header__mobile {
    width: 300px;
    background-color: white;
  }
  .header__mobile--menu {
    position: relative;
    right: 0;
  }
  .header__mobile--menu__item {
    list-style: none;
    color: black;
  }
}

@media (min-width: 740px) and (max-width: 1023px) {
  .header__logo {
    left: 25%;
  }
}
</style>
