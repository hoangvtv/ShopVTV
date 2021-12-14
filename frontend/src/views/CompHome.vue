<template>
  <div>
    <comp-slide />
    <!-- <test /> -->
    <div class="home__shop">
      <div class="container-fluid">
        <div class="row">
          <div class="col-6 p-0 home__overlay">
            <div class="home_container">
              <img
                class="home__img"
                style="height: var(--height--img-right)"
                src="https://zuynshop.netlify.app/static/media/b1.846305b7.jpg "
              />
            </div>
            <div class="box__title">New Arrivals</div>
            <div class="box__link">
              <!-- <a class="box__text" href="/product">Shop now</a> -->
              <router-link to="/product" class="box__text"
                >Shop now</router-link
              >
            </div>
          </div>
          <div class="col-6 pb-0">
            <div class="row">
              <div class="col-6 p-0 home__overlay">
                <div class="home_container">
                  <img
                    class="home__img"
                    style="height: var(--height--img-home-top)"
                    src="https://zuynshop.netlify.app/static/media/b2.d40da1ac.jpg"
                  />
                </div>
                <div class="box__title">Woman</div>
                <div class="box__link">
                  <router-link to="/product" class="box__text"
                    >Shop now</router-link
                  >
                </div>
              </div>
              <div class="col-6 p-0 home__overlay">
                <div class="home_container">
                  <img
                    class="home__img"
                    style="height: var(--height--img-home-top)"
                    src="https://zuynshop.netlify.app/static/media/b3.d66fc205.jpg"
                    alt=""
                  />
                </div>
                <div class="box__title">Man</div>
                <div class="box__link">
                  <router-link to="/product" class="box__text"
                    >Shop now</router-link
                  >
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-12 p-0 home__overlay">
                <div class="home_container">
                  <img
                    class="home__img"
                    src="https://zuynshop.netlify.app/static/media/b4.22dc7ed5.jpg"
                    style="height: var(--height--img-home-bottom)"
                  />
                </div>
                <div class="box__title">Free Shipping On All Orders</div>
                <div class="box__link">
                  <router-link to="/product" class="box__text" href=""
                    >Shop now</router-link
                  >
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import CompSlide from "../components/CompSlide.vue";
// import Test from "../components/Test.vue";
export default {
  components: { CompSlide },
};
</script>

<style>
:root {
  --height--img-home-top: 328px;
  --height--img-home-bottom: 328px;
  --height--img-right: calc(
    var(--height--img-home-top) + var(--height--img-home-bottom)
  );
}
.home__shop {
  margin: 50px 20px;
  position: relative;
}
.home__img {
  width: 100%;
  height: 100%;
}
.box__title {
  color: #fff;
  position: absolute;
  font-size: 30px;
  font-weight: 700;
  font-family: sans-serif;
  z-index: 5;
  top: 50%;
  left: 35%;
}
.box__link {
  display: none;
  position: absolute;
  width: 80%;
  height: 80%;
  z-index: 10;
  text-align: center;
  align-items: center;
  justify-content: center;
  background: rgba(3, 3, 3, 0.4);
  top: 10%;
  right: 10%;
  animation: fadeIn ease-in 0.4s;
}
.home__overlay:hover .box__link {
  display: flex;
}
.box__text {
  text-decoration: none;
  color: #fff;
}

@keyframes fadeIn {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}
</style>
