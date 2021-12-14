<template>
  <div class="sletter container">
    <div class="sletter__title">
      <h4 class="sletter__content">Newsletter</h4>
      <p class="sletter__text">
        Get timely updates from your favorite products
      </p>
    </div>
    <div class="sletter__input">
      <input
        type="email"
        class="sletter__search"
        placeholder="Enter your email address"
      />
      <button class="sletter__btn">Subscribe</button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
};
</script>

<style>
.sletter__title {
  display: block;
}
.sletter__content {
  text-align: center;
  font-size: 23px;
  margin-bottom: 20px;
  color: #333;
  font-weight: 600;
}
.sletter__text {
  margin-bottom: 35px;
  color: #777;
  font-size: 14px;
  text-align: center;
  padding-left: 20px;
}
.sletter__input {
  display: flex;
  height: 50px;
}
.sletter__search {
  flex: 2;
  line-height: 50px;
  margin-right: 20px;
  border-bottom: 1px solid #ddd;
  padding-left: 16px;
}
.sletter__search:focus {
  outline: none;
}
.sletter__btn {
  height: 50px;
  width: 90px;
  color: #fff;
  background-color: black;
  border-radius: 5px;
}
</style>
