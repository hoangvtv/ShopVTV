<template>
  <footer class="footer container-fluid">
    <ul class="footer__contact">
      <!-- <li class="contact--link">©2021 ZuynShop</li>
      <li class="contact--link">
        <router-link to="/product" class="contact--link"
          ><a>News</a></router-link
        >
      </li> -->
      <li class="contact--link">©2021 ZuynShop</li>
      <li class="contact--link">News</li>
      <li class="contact--link">FAQs</li>
      <li class="contact--link">
        <router-link to="/contact">Contact Us</router-link>
      </li>
    </ul>
    <ul class="footer__icon">
      <li class="contact--icon"><i class="fab fa-twitter"></i></li>
      <li class="contact--icon"><i class="fab fa-facebook-f"></i></li>
      <li class="contact--icon"><i class="fab fa-instagram"></i></li>
      <li class="contact--icon"><i class="fab fa-pinterest"></i></li>
      <li class="contact--icon"><i class="fab fa-google"></i></li>
    </ul>
  </footer>
</template>

<script>
export default {};
</script>

<style>
.footer {
  border-top: 1px solid #ddd;
  height: 80px;
  margin-top: 30px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.footer__contact {
  display: flex;
  /* padding-left: 0; */
}
.contact--link {
  list-style: none;
  margin-right: 40px;
}
.footer__icon {
  display: flex;
}
.contact--icon {
  list-style: none;
  margin-left: 40px;
}
</style>
