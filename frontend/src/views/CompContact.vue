<template>
  <div class="contact">
    <div class="contact__banner">
      <div class="contact__banner__img">
        <!-- <img
          class="contact__img"
          src="https://s3.cloud.cmctelecom.vn/tinhte1/2013/04/3338557_1.jpg"
        /> -->
        <img
          class="contact__img"
          src="https://www.w3schools.com/w3css/map.jpg"
        />
      </div>
    </div>
    <div class="contact__info">
      <div class="container info-list">
        <div class="info--title">
          Duis aute irure dolor in reprehenderit in voluptate velit esse cillum
          dolore eu fugiat nulla pariatur.
        </div>
        <div class="info--detail">
          <div class="info-item">
            <i class="fas fa-home"></i>
            <p class="item-title">ADDRESS</p>
            <p>Man Thiện, TP.Thủ Đức, TP.HCM</p>
          </div>
          <div class="info-item">
            <i class="fas fa-phone"></i>
            <p class="item-title">PHONE</p>
            <a href="tel:+00 151515 ">+00 151515</a>
          </div>
          <div class="info-item">
            <i class="fas fa-mail-bulk"></i>
            <p class="item-title">EMAIL</p>
            <!-- <p></p> -->
            <a href="mailto:zuynhop@google.com">vtvshop@google.com</a>
          </div>
        </div>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row">
        <div class="col-8">
          <iframe
            src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.511547008364!2d106.78350311462134!3d10.848642760823505!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752713216a3adf%3A0xf8b22853eea72777!2zOTcgxJDGsOG7nW5nIE1hbiBUaGnhu4duLCBIaeG7h3AgUGjDuiwgUXXhuq1uIDksIFRow6BuaCBwaOG7kSBI4buTIENow60gTWluaCwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1628221827840!5m2!1svi!2s"
            width="100%"
            height="450"
            style="border: 0"
            allowfullscreen=""
            loading="lazy"
          ></iframe>
        </div>
        <div class="col-4 form">
          <label class="form__label">Contact Us</label>
          <input type="text" class="form__item" placeholder="Name" />
          <input type="email" class="form__item" placeholder="Email" />
          <input type="text" class="form__item" placeholder="Subject" />
          <input type="text" class="form__item" placeholder="Message" />
          <button type="button form__item" class="btn btn-dark">
            Send Message
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
.contact {
  margin-bottom: 40px;
}
.contact__banner {
  position: relative;
}
.contact__banner::before {
  content: "Contact";
  font-size: 100px;
  position: absolute;
  top: 20%;
  left: 39%;
}

.contact__img {
  width: 100%;
  padding: 100px 0;
}
.contact__img::after {
  content: "Contact";
  font-size: 200px;
  z-index: 111111;
}

.banner__text {
  z-index: 5;
  font-size: 6vw;
  font-weight: 300;
  font-family: sans-serif;
  margin-bottom: 30px;
  text-transform: capitalize;
}

.banner__overlay {
  display: flex;
  justify-content: center;
}
.banner__home {
  display: flex;
  justify-content: center;
}
.info--title {
  margin-top: 50px;
  color: #888;
  font-size: 18px;
}
.info--detail {
  color: #888;
  margin-top: 50px;
  text-align: center;
  display: inline-block;
}
.info-list {
  text-align: center;
}
.info-item {
  display: flex;
  justify-content: flex-start;
}
.info-item a {
  color: #888 !important;
}
.item-title {
  margin: 0 60px;
}
.form {
  background-color: #edeff1;
  margin-left: -4px;
}
.form__label {
  display: flex;
  justify-content: center;
  text-align: center;
  font-size: 30px;
  margin-top: 50px;
  margin-bottom: 30px;
  font-family: Poppins-Medium;
}
.form__item {
  display: flex;
  width: 100%;
  line-height: 50px;
  margin-right: 20px;
  border-bottom: 1px solid #ddd;
  padding-left: 16px;
  margin-bottom: 20px;
}
.form__item:focus {
  outline: none;
}
</style>
