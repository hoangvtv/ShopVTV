<template>
  <div class="product">
    <div class="col-sm-12">
      <h2 class="product__title">Product</h2>

      <div class="offset">
        <div class="container">
          <div class="button">
            <div class="button__map">
              <button
                type="button"
                class="button__item btn btn-dark"
                @click="FilterAll"
              >
                All
              </button>
              <button
                type="button"
                class="button__item btn btn-dark"
                @click="FilterMen"
              >
                Men
              </button>
              <button
                type="button"
                class="button__item btn btn-dark"
                @click="FilterFemen"
              >
                Women
              </button>
            </div>
            <div class="button__filter">
              <p class="filter__text">
                Sắp xếp theo <i class="fas fa-chevron-down"></i>
              </p>
              <div class="filter__menu">
                <p class="filter__item" @click="FromLowToHigh">
                  Giá: thấp đến cao
                </p>
                <p class="filter__item" @click="FromHighToLow">
                  Giá: Cao đến thấp
                </p>
              </div>
            </div>
          </div>
          <div class="row">
            <div
              class="col-lg-3 col-md-4"
              v-for="product in displayedPosts"
              :key="product.sanPhamId"
            >
              <div class="card">
                <img
                  class="card-img-top card__img"
                  :src="product.hinhAnh"
                  alt="Card image"
                />
                <div class="card-body">
                  <h4 class="card-title">
                    <router-link :to="`/product/${product.sanPhamId}`">
                      {{ product.tenSanPham }}
                    </router-link>
                  </h4>
                  <h6 class="card-text">${{ product.giaSanPham }}</h6>
                  <div class="btn btn-dark" @click="setListCart(product)">
                    Add to Cart
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <nav aria-label="Page navigation example">
          <ul class="pagination pagination-menu">
            <li class="page-item">
              <button
                type="button"
                class="page-link"
                v-if="page != 1"
                @click="page--"
              >
                Previous
              </button>
            </li>
            <li class="page-item">
              <button
                type="button"
                class="page-link"
                v-for="pageNumber in pages.slice(page - 1, page + 5)"
                :key="pageNumber.index"
                @click="page = pageNumber"
              >
                {{ pageNumber }}
              </button>
            </li>
            <li class="page-item">
              <button
                type="button"
                @click="page++"
                v-if="page < pages.length"
                class="page-link"
              >
                Next
              </button>
            </li>
          </ul>
        </nav>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { mapState, mapGetters } from "vuex";
import { EventBus } from "../main.js";
export default {
  data() {
    return {
      posts: [""],
      postCurrent: [],
      page: 1,
      perPage: 12,
      pages: [],
      add: "Sản phẩm đã được thêm vào giỏ hàng",
    };
  },
  methods: {
    setListCart(product) {
      this.$store.commit("ADD_PRODUCTS", product);
      EventBus.$emit("openOverlay", this.add);
    },
    onChangePage(pageOfItems) {
      // update page of items
      this.pageOfItems = pageOfItems;
    },

    getPosts() {
      // let data = [];
      axios.get("http://localhost:8888/sanPham/dsSanPham").then((response) => {
        this.posts = response.data;
        this.postCurrent = response.data;
      });
    },
    setPages() {
      this.pages = [];
      let numberOfPages = Math.ceil(this.postCurrent.length / this.perPage);
      for (let index = 1; index <= numberOfPages; index++) {
        this.pages.push(index);
      }
    },
    paginate(posts) {
      let page = this.page;
      let perPage = this.perPage;
      let from = page * perPage - perPage;
      let to = page * perPage;
      return posts.slice(from, to);
    },
    search(e) {
      this.posts = this.postCurrent.filter((x) =>
        x.tenSanPham.toUpperCase().includes(e.toUpperCase())
      );
    },
    FilterAll() {
      this.posts = this.postCurrent;
    },
    FilterMen() {
      this.posts = this.postCurrent.filter(
        (x) => x.loaiSanPham.loaiSanPhamId == 1
      );
    },
    FilterFemen() {
      this.posts = this.postCurrent.filter(
        (x) => x.loaiSanPham.loaiSanPhamId == 2
      );
    },
    FromLowToHigh() {
      this.posts = this.posts.sort(function (a, b) {
        return a.giaSanPham - b.giaSanPham;
      });
    },
    FromHighToLow() {
      this.posts = this.posts.sort(function (a, b) {
        return b.giaSanPham - a.giaSanPham;
      });
    },
  },
  computed: {
    displayedPosts() {
      return this.paginate(this.posts);
    },
    ...mapGetters(["getCart"]),
    ...mapState(["listCartProducts"]),
  },
  watch: {
    postCurrent() {
      this.setPages();
    },
  },
  created() {
    this.getPosts();
    EventBus.$on("search", this.search);
    EventBus.$on("resetData", this.getPosts);
  },
  filters: {
    trimWords(value) {
      return value.split(" ").splice(0, 20).join(" ") + "...";
    },
  },
};
</script>
<style>
.product {
  margin-top: 150px;
  margin-left: 30px;
  font-weight: bold;
  font-size: 30px;
}
.product__title {
  margin-left: 30px;
}
.button {
  display: flex;
  justify-content: space-between;
}
.filter__text {
  font-size: 14px;
  font-weight: 500;
  margin-bottom: 4px !important;
  position: relative;
  display: flex;
  align-items: center;
  top: 16px;
  padding-left: 23px;
}

.button__filter {
  position: relative;
}
.button__filter:hover .filter__menu {
  display: block;
  background-color: #fff;
}
.filter__menu {
  border-right: 1px solid #ddd;
  border-left: 1px solid #ddd;
  border-bottom: 1px solid #ddd;
  display: none;
  position: absolute;
  z-index: 1;
  top: 35px;
}
.filter__menu::before {
  /* background-color: red; */
  content: "";
  position: absolute;
  display: block;
  width: 100%;
  height: 10px;
  /* top: -10px; */
  left: 0;
}
.filter__item {
  font-size: 14px;
  font-weight: 400;
  line-height: 30px;
  padding: 2px 0;
  margin-bottom: 4px !important;
  border-top: 1px solid #ddd;
}
.button__filter:hover {
  cursor: pointer;
}
.button__item {
  color: #fff !important;
  margin: 0 2px 10px 0;
}
.card {
  box-shadow: 0 1px 2px 0 rgb(0 0 0 / 10%);
}
.card:hover {
  transform: translateY(-3px);
  box-shadow: 0 1px 20px 0 rgb(0 0 0 / 5%);
  /* will-change: transform; */
}
.card-title {
  overflow: hidden;
  display: block;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 1;
  text-overflow: ellipsis;
}
.card-img-top {
  /* animation: growth ease-in 0.2s; */
  background-size: contain;
  width: 100%;
  height: 270px;
  transition: transform 0.2s;
}
.card-img-top:hover {
  transform: scale(1.05);
}
.pagination-menu {
  display: flex;
  justify-content: center;
}
button.page-link {
  display: inline-flex;
}
button.page-link {
  font-size: 20px;
  color: #29b3ed;
  font-weight: 500;
}
/* @keyframes growth {
  from {
    opacity: 0;
    transform: scale(0.7);
  }
  to {
    opacity: 1;
    transform: scale(0.1);
  }
} */
</style>
